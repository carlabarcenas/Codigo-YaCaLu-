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

public class BucketActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton btnBucket;
    private Button btnNext;
    private Button btnPrevious;
    private MediaPlayer mediaPlayer;
    private SoundPool soundPool;
    private  int  bucket;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket);

        btnBucket = (ImageButton) findViewById(R.id.btn_bucket);
        btnNext = (Button) findViewById(R.id.btn_nextbuck);
        btnPrevious = (Button) findViewById(R.id.btn_previousbuck);


        btnBucket.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);

        soundPool = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        bucket = soundPool.load(this, R.raw.bucket,1);
        mediaPlayer = new MediaPlayer();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bucket:
                soundPool.play(bucket, 1, 1,0,0,1);
                break;
            case R.id.btn_nextbuck:
                Intent i = new Intent(this, CameraActivity.class);
                startActivity(i);
                finish();
                break;
            case R.id.btn_previousbuck:
                Intent in = new Intent(this, BedActivity.class);
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
