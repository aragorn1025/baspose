package com.ehappy.baspost_01;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;

import android.widget.VideoView;

import com.ehappy.baspost_01.networking.ApiConfig;
import com.ehappy.baspost_01.networking.ApiConfig2;
import com.ehappy.baspost_01.networking.AppConfig;
import com.ehappy.baspost_01.networking.Classtype;
import com.ehappy.baspost_01.networking.ServerResponse;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.google.android.material.navigation.NavigationView;
import android.view.MenuItem;
import com.andremion.floatingnavigationview.FloatingNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


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

    private FloatingNavigationView mFloatingNavigationView;

    public static String filename;

    //which class chose in MainActivity.java
    public static int type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_nav_main);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        type = MainActivity.type;
        System.out.println(type);

        mFloatingNavigationView = (FloatingNavigationView) findViewById(R.id.floating_navigation_view);
        mFloatingNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFloatingNavigationView.open();
            }
        });
        mFloatingNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Snackbar.make((View) mFloatingNavigationView.getParent(), item.getTitle() + " Selected!", Snackbar.LENGTH_SHORT).show();

                switch (item.getItemId()){

                    case R.id.nav_home:
                        Intent mainIntent = new Intent(UploadVideo.this,MainActivity.class);
                        UploadVideo.this.startActivity(mainIntent);
                        break;

                }

                mFloatingNavigationView.close();
                return true;
            }
        });

//        //for FloatingNavigationView
//        mFloatingNavigationView = (FloatingNavigationView) findViewById(R.id.floating_navigation_view);
//        mFloatingNavigationView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mFloatingNavigationView.open();
//            }
//        });
//        mFloatingNavigationView.setNavigationItemSelectedListener(this);

        //function for choose video and upload video buttons
        button = findViewById(R.id.choosebt);
        uploadVideo = findViewById(R.id.correctbt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pickVideoIntent = new Intent(Intent.ACTION_GET_CONTENT);
                pickVideoIntent.setType("video/*");
                //get the chosen video's path
                startActivityForResult(pickVideoIntent, REQUEST_PICK_VIDEO);
            }
        });

        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(UploadVideo.this,videoPath,Toast.LENGTH_LONG).show();
                if(video!=null){
                    uploadFile(videoPath);
                    //uploadClass(type);
                }else{
                    Toast.makeText(UploadVideo.this,"Please select a video",Toast.LENGTH_LONG).show();
                }
            }
        });

        //play the chosen video
        mVideoView = findViewById(R.id.videoView);
        //myBufferingTextView
        if(savedInstanceState!=null){
            myCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(controller);

        //initialize the progress bar
        initDialog();
    }

    @Override
    public void onBackPressed() {
        if (mFloatingNavigationView.isOpened()) {
            mFloatingNavigationView.close();
        } else {
            super.onBackPressed();
        }
    }

    //for video view
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
//                        Toast.makeText(UploadVideo.this,
//                                "Playback completed",
//                                Toast.LENGTH_LONG).show();
                        mVideoView.seekTo(0);
                    }
                }
        );
    }
    private void releasePlayer(){mVideoView.stopPlayback();}



    //within on click choose button function
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if (requestCode == REQUEST_PICK_VIDEO) {
                if (data != null) {
//                    Toast.makeText(this, "Video content URI: " + data.getData(),
//                            Toast.LENGTH_LONG).show();
                    video = data.getData();
                    videoPath = getPath(video);

                    System.out.println("videoPath:"+videoPath);

                    //Toast.makeText(UploadVideo.this,videoPath,Toast.LENGTH_LONG).show();
                    initializePlayer(video);
                }
            }
        }
        else if (resultCode != RESULT_CANCELED) {
            Toast.makeText(this, "Sorry, there was an error!", Toast.LENGTH_LONG).show();
        }
    }

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

    private void uploadClass(int type){

        System.out.println("uploadClass type is "+type);

        OkHttpClient client = new OkHttpClient();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://140.115.51.184:40130/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiConfig2 service = retrofit.create(ApiConfig2.class);
        Classtype classtype = new Classtype();
        classtype.setType(type);

        Call<Classtype> call = service.insertData(classtype.getType());

        call.enqueue(new Callback<Classtype>() {
            @Override
            public void onResponse(Call<Classtype> call, Response<Classtype> response) {

                Toast.makeText(UploadVideo.this, "response"+response, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Classtype> call, Throwable t) {


                Log.i("Hello",""+t);
                Toast.makeText(UploadVideo.this, "Throwable"+t, Toast.LENGTH_LONG).show();

            }
        });

//        ApiConfig2 getResponse2 = AppConfig.getRetrofit().create(ApiConfig2.class);
//
//        Call<ServerResponse> call2 = getResponse2.upload_class(type);
//        call2.enqueue(new Callback<ServerResponse>() {
//            @Override
//            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//                        //showpDialog();
//                        ServerResponse serverResponse = response.body();
//                        Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                } else {
//                    //hidepDialog();
//                    System.out.println("!response.isSuccessful()");
//                    //ServerResponse serverResponse = response.body();
//                    //Log.v("Response gotten is", serverResponse.getMessage());
//                    //Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ServerResponse> call, Throwable t) {
//
//                //hidepDialog();
//                Log.v("(on failure)Response gotten is", t.getMessage());
//                //Toast.makeText(getApplicationContext(), "problem uploading video " + t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//
//        });
    }

    //
    private void uploadFile(String videoPath) {

        //Toast.makeText(UploadVideo.this,videoPath,Toast.LENGTH_LONG).show();

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
            map.put("file\"; filename=\"" +type+ file.getName()  +"\"", requestBody);

            System.out.println("file.getName"+file.getName());
            filename = type+file.getName();

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

                            Intent intent = new Intent(UploadVideo.this, WaitingActivity.class);
                            startActivity(intent);
                        }
                    }else {
                        //hidepDialog();
                        System.out.println("!response.isSuccessful()");
                        ServerResponse serverResponse = response.body();
                        Log.v("Response gotten is", serverResponse.getMessage());
                        Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(UploadVideo.this, WaitingActivity.class);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<ServerResponse> call, Throwable t) {
                    //hidepDialog();
                    Log.v("(on failure)Response is", t.getMessage());
                    //Toast.makeText(getApplicationContext(), "problem uploading video " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UploadVideo.this, WaitingActivity.class);
                    startActivity(intent);

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