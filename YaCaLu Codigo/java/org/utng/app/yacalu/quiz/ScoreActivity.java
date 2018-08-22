package org.utng.app.yacalu.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.utng.app.yacalu.MenuActivity;
import org.utng.app.yacalu.QuizActivity;
import org.utng.app.yacalu.R;

public class ScoreActivity extends AppCompatActivity {
    private TextView tvContent;
    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        //Relacionar con XML
        tvContent = (TextView)findViewById(R.id.txt_content);
        //Se recupera la información del intent
        Bundle bundle = this.getIntent().getExtras();
        //Se muestra el dato en la etiqueta
        tvContent.setText(getString(R.string.msg_congratulations) + " " + bundle.getString( "points") + (R.string.hits));

        btnReturn = (Button) findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_quiz = new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(back_quiz);
                finish();
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent home = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(home);
        finish();

        return super.onKeyDown(keyCode, event);
    }

}
