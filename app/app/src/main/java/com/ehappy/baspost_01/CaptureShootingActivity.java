package com.ehappy.baspost_01;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CaptureShootingActivity extends AppCompatActivity {

    private final int VIDEO_REQUEST_CODE = 100;
    private Uri videoUri = null;

    private Button capture,changeToUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captureshooting);

        capture = findViewById(R.id.capturebt);
        changeToUpload = findViewById(R.id.nextbt);

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

    }

    //when click next button
    public void changeToUpload(View view){

        Intent uploadIntent = new Intent(CaptureShootingActivity.this,UploadVideo.class);
        CaptureShootingActivity.this.startActivity(uploadIntent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == VIDEO_REQUEST_CODE && resultCode == RESULT_OK)
        {
            videoUri = data.getData();
        }
    }

}
