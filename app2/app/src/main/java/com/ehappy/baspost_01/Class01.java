package com.ehappy.baspost_01;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class Class01 extends AppCompatActivity {

    private final int VIDEO_REQUEST_CODE = 100;

    private Uri videoUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class01);

        final VideoView videov= findViewById(R.id.vclass01);
        MediaController mediaC = new MediaController(this);

        String videopath = "android.resource://com.ehappy.baspost_01/"+R.raw.shooting;
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

    }

    public void captureVideo(View view){

        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        if(videoIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(videoIntent,VIDEO_REQUEST_CODE);
        }

    }


    //when click next button
    public void changeToUpload(View view){

        Intent uploadIntent = new Intent(Class01.this,UploadVideo.class);
        Class01.this.startActivity(uploadIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if(requestCode == VIDEO_REQUEST_CODE && resultCode == RESULT_OK)
        {
            videoUri = data.getData();
        }

    }

}
