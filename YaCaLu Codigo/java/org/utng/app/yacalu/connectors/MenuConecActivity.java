package org.utng.app.yacalu.connectors;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.utng.app.yacalu.MenuActivity;
import org.utng.app.yacalu.R;
import org.utng.app.yacalu.connectors.ConclusiveConnectorsActivity;


public class MenuConecActivity extends AppCompatActivity {
    private Button btnConclusion;
    private Button btnContinous;
    private Button btnAdversatives;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_conec);


        btnConclusion = (Button) findViewById(R.id.btn_conclusive);
        btnConclusion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ConclusiveConnectorsActivity.class);
                startActivityForResult(intent, 0);

            }

        });
        btnContinous = (Button) findViewById(R.id.btn_continuos);
        btnContinous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ContinuativesConnectorsActivity.class);
                startActivityForResult(intent, 0);
            }
        });
        btnAdversatives = (Button) findViewById(R.id.btn_adverse);
        btnAdversatives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AdversativesConnectorsActivity.class);
                startActivityForResult(intent, 0);
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
        finish();
    }
}