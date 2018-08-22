package org.utng.app.yacalu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import org.utng.app.yacalu.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnRegistrar, btnLogin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private String stEmail;
    private String stPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        //Referenciamos los views
        etEmail = (EditText) findViewById(R.id.tv_email);
        etPassword = (EditText) findViewById(R.id.tv_password);

        btnRegistrar = (Button) findViewById(R.id.btn_registrar);
        btnLogin = (Button) findViewById(R.id.btn_login);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        btnRegistrar.setOnClickListener((View.OnClickListener) this);
        btnLogin.setOnClickListener(this);
    }

    private void registrarUsuario() {

        //Obtenemos el email y la contraseña desde las cajas de texto
        stEmail = etEmail.getText().toString().trim();
        stPassword = etPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(stEmail)) {
            Toast.makeText(this, (R.string.needEmail), Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(stPassword)) {
            Toast.makeText(this, (R.string.needPasw), Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("\n" + ("android.resource://org.utng.app.yacalu/"+ R.string.onlineregistrer));
        progressDialog.show();

        //creating a new user
        firebaseAuth.createUserWithEmailAndPassword(stEmail, stPassword)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {

                            Toast.makeText(LoginActivity.this, ("android.resource://org.utng.app.yacalu/"+ R.string.registrer) + etEmail.getText(), Toast.LENGTH_LONG).show();
                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException)
                                Toast.makeText(LoginActivity.this, ("android.resource://org.utng.app.yacalu/"+ R.string.thatexist), Toast.LENGTH_LONG).show();
                            else {
                                Toast.makeText(LoginActivity.this, ("android.resource://org.utng.app.yacalu/"+ R.string.users) + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    private void loguearUsiario() {
//Obtenemos el email y la contraseña desde las cajas de texto
        final String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, ("android.resource://org.utng.app.yacalu/"+ R.string.email), Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, ("android.resource://org.utng.app.yacalu/"+ R.string.password), Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("\n" + ("android.resource://org.utng.app.yacalu/"+ R.string.loginonline));
        progressDialog.show();

        //Login a user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            int pos = email.indexOf("@");
                            String user = email.substring(0, pos);

                            Toast.makeText(LoginActivity.this, ("android.resource://org.utng.app.yacalu/"+ R.string.Welcome) + etEmail.getText(), Toast.LENGTH_LONG).show();

                            Intent intencion = new Intent(getApplication(), MenuActivity.class);
                            intencion.putExtra(WellcomeActivity.user, user);
                            startActivity(intencion);


                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException)
                                Toast.makeText(LoginActivity.this, ("android.resource://org.utng.app.yacalu/"+ R.string.exists), Toast.LENGTH_LONG).show();
                            else {
                                Toast.makeText(LoginActivity.this, ("android.resource://org.utng.app.yacalu/"+ R.string.verify), Toast.LENGTH_LONG).show();
                            }
                        }
                        progressDialog.dismiss();
                    }
                });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_registrar:
                //Invocamos al método:
                registrarUsuario();
                break;

            case R.id.btn_login:
                loguearUsiario();


        }

    }
}