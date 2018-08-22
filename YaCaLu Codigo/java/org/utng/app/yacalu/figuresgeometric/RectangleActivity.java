package org.utng.app.yacalu.figuresgeometric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.utng.app.yacalu.R;


public class RectangleActivity extends AppCompatActivity implements View.OnClickListener{



private ImageButton btnRectangle;
private Button btnNext;
private Button btnPrevious;
private MediaPlayer mediaPlayer;
private SoundPool soundPool;
private int rectangle;



@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        btnRectangle = (ImageButton) findViewById(R.id.btn_rectangle);
        btnNext = (Button) findViewById(R.id.btn_nextr);
        btnPrevious = (Button) findViewById(R.id.btn_previousr);


        btnRectangle.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        rectangle = soundPool.load(this, R.raw.rectangle,1);
        mediaPlayer = new MediaPlayer();

        }
@Override
public void onClick(View v) {
        switch (v.getId()){
        case R.id.btn_rectangle:
        soundPool.play(rectangle, 1, 1,0,0,1);
        break;
        case R.id.btn_next:
        Intent i = new Intent(this,TriangleActivity.class);
        startActivity(i);
        finish();
        break;
        case R.id.btn_previous:
        Intent in = new Intent(this, DiamondActivity.class);
        startActivity(in);
        finish();
        break;
default:
        break;


        }
        }


        }