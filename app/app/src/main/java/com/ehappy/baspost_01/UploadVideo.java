package com.ehappy.baspost_01;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.ehappy.baspost_01.networking.ApiConfig;
import com.ehappy.baspost_01.networking.AppConfig;
import com.ehappy.baspost_01.networking.ServerResponse;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UploadVideo extends AppCompatActivity {
    Button button,uploadVideo;
    public static final int REQUEST_PICK_VIDEO = 3;
    public ProgressBar pDialog;

    private VideoView mVideoView;
    //private TextView mBufferingTextView;
    private Uri video;
    //private String videoPath;
    public String videoPath;

    private int myCurrentPosition = 0;
    private static final String PLAYBACK_TIME = "play_time";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_video);

        button = findViewById(R.id.choosebt);
        uploadVideo = findViewById(R.id.correctbt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickVideoIntent = new Intent(Intent.ACTION_GET_CONTENT);
                pickVideoIntent.setType("video/*");
                startActivityForResult(pickVideoIntent, REQUEST_PICK_VIDEO);
            }
        });


        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(UploadVideo.this,videoPath,Toast.LENGTH_LONG).show();
                if(video!=null){
                    uploadFile(videoPath);
                }else{
                    Toast.makeText(UploadVideo.this,"Please select a video",Toast.LENGTH_LONG).show();
                }
            }
        });


        mVideoView = findViewById(R.id.videoView);
        //myBufferingTextView

        if(savedInstanceState!=null){
            myCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }

        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(controller);

        initDialog();
    }

    @Override
    protected void onPause(){
        super.onPause();

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
            mVideoView.pause();
        }
    }

    protected void onStop(){
        super.onStop();

        releasePlayer();
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt(PLAYBACK_TIME,mVideoView.getCurrentPosition());
    }

    private void initializePlayer(Uri uri){

        //myBufferingTextView.setvisibility

        if(uri != null){

            mVideoView.setVideoURI(uri);
        }


        mVideoView.setOnPreparedListener(

                new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        //myBufferingTextView.setvisibility

                        if(myCurrentPosition >0){
                            mVideoView.seekTo(myCurrentPosition);

                        }else{

                            mVideoView.seekTo(1);
                        }

                        mVideoView.start();
                    }
                });

        mVideoView.setOnCompletionListener(

                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(UploadVideo.this,
                                "Playback completed",
                                Toast.LENGTH_LONG).show();

                        mVideoView.seekTo(0);
                    }
                }
        );
    }

    private void releasePlayer(){mVideoView.stopPlayback();}



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == REQUEST_PICK_VIDEO) {
                if (data != null) {
                    Toast.makeText(this, "Video content URI: " + data.getData(),
                            Toast.LENGTH_LONG).show();
                    video = data.getData();

                    videoPath = getPath(video);
                    //videoPath = getPath(video,null);


                    //Log.e("error",video.toString());

                    Toast.makeText(UploadVideo.this,videoPath,Toast.LENGTH_LONG).show();

                    initializePlayer(video);

                }
            }
        }
        else if (resultCode != RESULT_CANCELED) {
            Toast.makeText(this, "Sorry, there was an error!", Toast.LENGTH_LONG).show();
        }
    }

//    public String getPath(Uri uri){
//        String[] projection = {MediaStore.Video.Media.DATA};
//        Cursor cursor = getContentResolver().query(uri,projection,null,null);
//
//        if(cursor!=null){
//
//            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
//            cursor.moveToFirst();
//            return cursor.getString(column_index);
//        }else
//        {
//            return null;
//        }
//
//    }

    public String getPath(Uri uri){
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":")+1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Video.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
        cursor.close();

        return path;
    }

    private void uploadFile(String videoPath) {

        Toast.makeText(UploadVideo.this,videoPath,Toast.LENGTH_LONG).show();


        if (video == null || video.equals("")) {
            Toast.makeText(this, "please select a video ", Toast.LENGTH_LONG).show();
            return;
        } else {

            //showpDialog();

            // Map is used to multipart the file using okhttp3.RequestBody
            Map<String, RequestBody> map = new HashMap<>();
            File file = new File(videoPath);

            // Parsing any Media type file
            RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
            map.put("file\"; filename=\"" + file.getName() + "\"", requestBody);
            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);
            Call<ServerResponse> call = getResponse.upload("token", map);
            call.enqueue(new Callback<ServerResponse>() {
                @Override
                public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                    if (response.isSuccessful()){
                        if (response.body() != null){
                            //showpDialog();
                            ServerResponse serverResponse = response.body();
                            Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }else {
                        //hidepDialog();
                        Toast.makeText(getApplicationContext(), "problem uploading video", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ServerResponse> call, Throwable t) {
                    //hidepDialog();
                    Log.v("Response gotten is", t.getMessage());
                    Toast.makeText(getApplicationContext(), "problem uploading video " + t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }


    protected void initDialog() {

        pDialog =  findViewById(R.id.progressbar);
        pDialog.setVisibility(View.INVISIBLE);
    }


    protected void showpDialog() {

        pDialog.setVisibility(View.VISIBLE);
    }

    protected void hidepDialog() {

        pDialog.setVisibility(View.INVISIBLE);
    }

}