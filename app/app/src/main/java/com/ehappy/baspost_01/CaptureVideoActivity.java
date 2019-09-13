package com.ehappy.baspost_01;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;

import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureVideoActivity extends AppCompatActivity {

    private SurfaceView mySurfaceView;
    private TextView myTextView;
    private Camera camera;
    private MediaRecorder recorder;
    private Button recordbt;
    public String fileextn = ".mp4";
    File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture_video);

        mySurfaceView = findViewById(R.id.id_sv);
        myTextView = findViewById(R.id.id_cross);
        recordbt = findViewById(R.id.id_bt);

        mySurfaceView.getHolder().addCallback(new MycallBack());

        //when press record




        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.RECORD_AUDIO },
                    10);


            //sdk permission
            if (Build.VERSION.SDK_INT >= 23) {
                int REQUEST_CODE_CONTACT = 101;
                String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                //验证是否许可权限
                for (String str : permissions) {
                    if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                        //申请权限
                        this.requestPermissions(permissions, REQUEST_CODE_CONTACT);
                        return;
                    }
                }
            }

        } else {

            startRecording();
        }

//        recordbt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)
//                        != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.RECORD_AUDIO },
//                            10);
//                } else {
//
//                    startRecording();
//                }
//            }
//        });

    }

    private void startRecording() {

        recordbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button button = (Button) v;

                //Record Audio.
                if("start".equals(button.getText()))
                {
                    button.setText("stop");

                    camera.unlock();
                    recorder = new MediaRecorder();
                    recorder.setCamera(camera);
                    recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                    recorder.setVideoSource(MediaRecorder.VideoSource
                            .CAMERA);
                    recorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));


//                    recorder.setOutputFile("mnt/sdcard"+ SystemClock.uptimeMillis()
//                            +".mp4");

                    //recorder.setOutputFile("/sdcard"+ SystemClock.uptimeMillis()+".mp4");

                    //recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                    //recorder.setOutputFile(getFilePath());

                    recorder.setOutputFile(initFile().getAbsolutePath());

                    recorder.setPreviewDisplay(mySurfaceView.getHolder().getSurface());

                    try {
                        recorder.prepare();
                        recorder.start();

                        System.out.println("camera start success");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else
                {
                    button.setText("start");

                    recorder.stop();
                    recorder.release();

                    recorder = null;

                    camera.lock();

                    System.out.println("camera lock success");

                    Intent class01Intent = new Intent(CaptureVideoActivity.this,Class01.class);
                    CaptureVideoActivity.this.startActivity(class01Intent);

                }

            }

        });

    }

    public File initFile() {

        File dir = new File(Environment.getExternalStorageDirectory(), this
                .getClass().getPackage().getName());


        if (!dir.exists() && !dir.mkdirs()) {


            file = null;
        } else {
            file = new File(dir.getAbsolutePath(), new SimpleDateFormat(
                    "'IMG_'yyyyMMddHHmmss'.mp4'").format(new Date()));
        }
        return file;
    }


    private String getFilePath() {

        String filepath = Environment.getExternalStorageDirectory().getPath();
        File file = new File(filepath, "MediaRecorderSample");

        if (!file.exists())
            file.mkdirs();

        System.out.println(file.getAbsolutePath() + "/" + fileextn);

        return (file.getAbsolutePath() + "/" + fileextn);
    }


    private class MycallBack implements SurfaceHolder.Callback{


        @Override
        public void surfaceCreated(SurfaceHolder holder) {

            try{

                camera = Camera.open();
                camera.setPreviewDisplay(mySurfaceView.getHolder());
                camera.startPreview();


            }catch (IOException e)
            {
                e.printStackTrace();
            }


        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

            if(camera!=null){
                camera.stopPreview();
                camera.release();
                camera = null;
            }

        }
    }
}
