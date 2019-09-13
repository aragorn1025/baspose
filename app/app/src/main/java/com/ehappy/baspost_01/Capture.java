package com.ehappy.baspost_01;

import android.content.Intent;
import android.hardware.Camera;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class Capture extends AppCompatActivity {

    private SurfaceView mySurfaceView;

    private final int VIDEO_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

//        mySurfaceView = findViewById(R.id.id_sv);
//
//        mySurfaceView.getHolder().addCallback(new CaptureVideoActivity.MycallBack());



        Intent videoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

        if(videoIntent.resolveActivity(getPackageManager())!=null)
        {
            startActivityForResult(videoIntent,VIDEO_REQUEST_CODE);
        }
    }

//    private class MycallBack implements SurfaceHolder.Callback{
//
//
//        @Override
//        public void surfaceCreated(SurfaceHolder holder) {
//
//            try{
//
//                camera = Camera.open();
//                camera.setPreviewDisplay(mySurfaceView.getHolder());
//                camera.startPreview();
//
//
//            }catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//
//
//        }
//
//        @Override
//        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//        }
//
//        @Override
//        public void surfaceDestroyed(SurfaceHolder holder) {
//
//            if(camera!=null){
//                camera.stopPreview();
//                camera.release();
//                camera = null;
//            }
//
//        }
//    }
}
