package org.utng.app.yacalu.vocabulary;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import org.utng.app.yacalu.*;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainVocabularyActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton ibtIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vocabulary);
        ibtIniciar = (ImageButton)findViewById(R.id.btn_iniciar);
        ibtIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, org.utng.app.yacalu.vocabulary.VocabularyActivity.class);
        startActivity(i);
    }
}