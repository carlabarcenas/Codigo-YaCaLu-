package org.utng.app.yacalu.figuresgeometric;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.utng.app.yacalu.R;

import android.support.v7.app.AppCompatActivity;

public class CircleActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btnCircle;
    private Button btnNext;
    private Button btnPrevious;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private int circle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        btnCircle = (ImageButton) findViewById(R.id.btn_circle);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnPrevious = (Button) findViewById(R.id.btn_previous);


        btnCircle.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        circle = soundPool.load(this, R.raw.circle,1);
        mediaPlayer = new MediaPlayer();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_circle:
                soundPool.play(circle, 1, 1,0,0,1);
                break;
            case R.id.btn_next:
                Intent i = new Intent(this, DiamondActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.btn_previous:
                Intent in = new Intent(this, FigureActivity.class);
                startActivity(in);
                finish();
                break;
            default:
                break;


        }
    }


}
