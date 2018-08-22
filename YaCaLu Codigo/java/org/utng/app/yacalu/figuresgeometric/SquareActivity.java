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

import org.utng.app.yacalu.MenuActivity;
import org.utng.app.yacalu.R;

public class SquareActivity extends AppCompatActivity implements View.OnClickListener{



private ImageButton btnSquare;
private Button btnNext;
private Button btnPrevious;
private MediaPlayer mediaPlayer;
private SoundPool soundPool;
private int square;



@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_square);

        btnSquare = (ImageButton) findViewById(R.id.btn_square);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnPrevious = (Button) findViewById(R.id.btn_previous);


        btnSquare.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        square = soundPool.load(this, R.raw.square,1);
        mediaPlayer = new MediaPlayer();

        }
@Override
public void onClick(View v) {
        switch (v.getId()){
        case R.id.btn_square:
        soundPool.play(square, 1, 1,0,0,1);
        break;
        case R.id.btn_next:
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
        finish();
        break;
        case R.id.btn_previous:
        Intent in = new Intent(this, TriangleActivity.class);
        startActivity(in);
        finish();
        break;
default:
        break;


        }
        }


        }