package com.ehappy.baspost_01;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class ShootingClass extends AppCompatActivity {

    private Button nexttocapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shooting_class);

        final VideoView videov= findViewById(R.id.vclass01);
        MediaController mediaC = new MediaController(this);

        String videopath = "android.resource://com.ehappy.baspost_01/"+R.raw.shootclass;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);

        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);

        videov.requestFocus();
        //监听播放完成，
        videov.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { @Override
        public void onCompletion(MediaPlayer mp) { //重新开始播放
            videov.start();
        } });


        nexttocapture = findViewById(R.id.nextbt);

        nexttocapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToCapture(v);
            }
        });

    }

    //when click next button
    public void changeToCapture(View view){

        Intent captureIntent = new Intent(ShootingClass.this,CaptureShootingActivity.class);
        ShootingClass.this.startActivity(captureIntent);
    }
}
