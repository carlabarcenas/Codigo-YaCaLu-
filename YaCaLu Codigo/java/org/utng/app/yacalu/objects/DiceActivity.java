package org.utng.app.yacalu.objects;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.utng.app.yacalu.MenuActivity;
import org.utng.app.yacalu.R;

public class DiceActivity  extends AppCompatActivity implements View.OnClickListener{
private ImageButton btnDice;
private Button btnNext;
private Button btnPrevious;
private MediaPlayer mediaPlayer;
private SoundPool soundPool;
private int dice;


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);


        btnDice = (ImageButton) findViewById(R.id.btn_dice);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnPrevious = (Button) findViewById(R.id.btn_previous);


        btnDice.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        dice = soundPool.load(this, R.raw.dice,1);
        mediaPlayer = new MediaPlayer();

        }
@Override
public void onClick(View v) {
        switch (v.getId()){
        case R.id.btn_dice:
        soundPool.play(dice, 1, 1,0,0,1);
        break;
        case R.id.btn_next:
        Intent i = new Intent(this, GlassesActivity.class);
        startActivity(i);
        finish();
        break;
        case R.id.btn_previous:
        Intent in = new Intent(this, ComputerActivity.class);
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
