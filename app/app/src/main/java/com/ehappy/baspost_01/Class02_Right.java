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
import android.widget.VideoView;

public class Class02_Right extends AppCompatActivity {

    private final int VIDEO_REQUEST_CODE = 100;

    private Uri uri = null;

    private Uri videoUri = null;

    private Button capture,changeToUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class02__right);

        MainActivity.type = 1;

        final VideoView videov= findViewById(R.id.vclass02);
        MediaController mediaC = new MediaController(this);

        capture = findViewById(R.id.btcorrect);
        changeToUpload = findViewById(R.id.nextbt);


        String videopath = "android.resource://com.ehappy.baspost_01/"+R.raw.layup;
        uri = Uri.parse(videopath);
        videov.setVideoURI(uri);


        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);

        videov.requestFocus();
        //监听播放完成，
        videov.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { @Override
        public void onCompletion(MediaPlayer mp) { //重新开始播放
            videov.start();
        } });


        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                captureVideo(v);
            }
        });

        changeToUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeToUpload(v);
            }
        });


    }

    public void captureVideo(View view){

        //Original

        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        if(videoIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(videoIntent,VIDEO_REQUEST_CODE);
        }


//        Intent captureIntent = new Intent(Class02_Right.this,CaptureVideoActivity.class);
////        Class02_Right.this.startActivity(captureIntent);
////
    }


    //when click next button
    public void changeToUpload(View view){

        Intent uploadIntent = new Intent(Class02_Right.this,UploadVideo.class);
        Class02_Right.this.startActivity(uploadIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {


        if(requestCode == VIDEO_REQUEST_CODE && resultCode == RESULT_OK)
        {
            videoUri = data.getData();
        }

    }
}
