package org.utng.app.yacalu;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import org.utng.app.yacalu.R;

public class CondicionalsActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_condicionals);
        VideoView videoView = findViewById(R.id.vv_conditional);
        Uri path = Uri.parse("android.resource://org.utng.app.yacalu./"+R.raw.conditionals);
        //
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoURI(path);
        videoView.start();

    }
}






