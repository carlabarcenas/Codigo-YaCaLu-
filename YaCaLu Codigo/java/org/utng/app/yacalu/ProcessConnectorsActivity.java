package org.utng.app.yacalu;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.utng.app.yacalu.connectors.MenuConecActivity;

public class ProcessConnectorsActivity extends AppCompatActivity {

    private Button menuConect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_proceso_conec);



        menuConect = (Button) findViewById(R.id.btn_gomenu);
        menuConect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MenuConecActivity.class);
                startActivityForResult(intent, 0);
            }

        });

    }
}
