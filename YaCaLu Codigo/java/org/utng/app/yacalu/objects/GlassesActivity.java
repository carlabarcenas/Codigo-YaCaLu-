package org.utng.app.yacalu.objects;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.utng.app.yacalu.MenuActivity;
import org.utng.app.yacalu.R;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GlassesActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btnGlasses;
    private Button btnNext;
    private Button btnReturn;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int glasses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glasses);

        btnGlasses = (ImageButton) findViewById(R.id.btn_glasses);
        btnNext = (Button) findViewById(R.id.btn_glasses0);
        btnReturn = (Button) findViewById(R.id.btn_glasses1);


        btnGlasses.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnReturn.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        glasses = soundPool.load(this, R.raw.glasees,1);
        mediaPlayer = new MediaPlayer();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_glasses:
                soundPool.play(glasses, 1, 1,0,0,1);
                break;
            case R.id.btn_glasses0:
                Intent i = new Intent(this, KeysActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.btn_glasses1:
                Intent in = new Intent(this, DiceActivity.class);
                startActivity(in);
                finish();
                break;
            default:
                break;


        }


    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
        finish();
    }
}