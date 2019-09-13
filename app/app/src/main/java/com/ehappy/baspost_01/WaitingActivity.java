package com.ehappy.baspost_01;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.xml.transform.Result;

public class WaitingActivity extends AppCompatActivity {

    public static String filename;

    private ProgressBar loading;
    public int error = -1;


    //which class i chose in Class01.java
    public static int type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        loading = findViewById(R.id.loading);

        filename = UploadVideo.filename;
        System.out.println(filename);

        //according to which class he chose, get relative judges
        type = MainActivity.type;
        System.out.println("which type?(0:shoot,1:layup_right) : "+type);



//        Handler handlerE = new Handler();
//        handlerE.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                checkError(filename);
//                System.out.println("error : "+error);
//            }
//        },30000);


//        if(error  == 0)
//        {
//            Handler handler = new Handler();
////
////            handler.postDelayed(new Runnable() {
////                public void run() {
////                    getjudge_shoot(filename);
////
////                }
////            }, 15000);

//        }else if(error == 1)
//        {
//
//            ErrorAction();
//        }

        if(type == 0)
        {
            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                public void run() {
                    getjudge_shoot(filename);

                }
            }, 15000);
        }
        else if(type == 1)
        {
            Handler handler = new Handler();

            handler.postDelayed(new Runnable() {
                public void run() {
                    getjudge_layup_right(filename);

                }
            }, 15000);
        }


    }

    private void ErrorAction()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(WaitingActivity.this);
        builder.setMessage("Video incorrectly captured! Please capture once again.")
                .setNegativeButton("OK", null)
                .create()
                .show();

        Intent classIntent = new Intent(WaitingActivity.this,Class01.class);
        WaitingActivity.this.startActivity(classIntent);
    }

    private void checkError(final String filename)
    {
        loading.setVisibility(View.VISIBLE);

        Response.Listener<String> responseListener0 = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{

                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if(success)
                    {
                        error = jsonResponse.getInt("error");
                    }

                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ErrorRequest errorRequest = new ErrorRequest(filename, responseListener0);
        RequestQueue queue = Volley.newRequestQueue(WaitingActivity.this);
        queue.add(errorRequest);

    }

    private void getjudge_shoot(final String filename) {

        loading.setVisibility(View.VISIBLE);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean successbefore = jsonResponse.getBoolean("successbefore");
                    boolean successafter = jsonResponse.getBoolean("successafter");

                    if (successbefore && successafter) {

                        loading.setVisibility(View.GONE);

                        double anglebefore = jsonResponse.getDouble("anglebefore");
                        String commentbefore = jsonResponse.getString("commentbefore");
                        String date = jsonResponse.getString("date");

                        double angleafter = jsonResponse.getDouble("angleafter");
                        String commentafter= jsonResponse.getString("commentafter");
                        int wrist = jsonResponse.getInt("wrist");



                        Intent intent = new Intent(WaitingActivity.this, ResultActivity.class);
                        intent.putExtra("anglebefore", anglebefore);
                        intent.putExtra("commentbefore", commentbefore);
                        intent.putExtra("angleafter", angleafter);
                        intent.putExtra("commentafter", commentafter);
                        intent.putExtra("wrist", wrist);
                        intent.putExtra("date", date);
                        WaitingActivity.this.startActivity(intent);


                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WaitingActivity.this);
                        builder.setMessage("Analyze Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ResultRequest resultRequest = new ResultRequest(filename, responseListener);
        RequestQueue queue = Volley.newRequestQueue(WaitingActivity.this);
        queue.add(resultRequest);


    }

    private void getjudge_layup_right(final String filename) {

        loading.setVisibility(View.VISIBLE);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");


                    if (success) {

                        loading.setVisibility(View.GONE);

                        int step1 = jsonResponse.getInt("step1");
                        int traveling = jsonResponse.getInt("traveling");
                        int straight = jsonResponse.getInt("straight");
                        String date = jsonResponse.getString("date");

                        Intent intent = new Intent(WaitingActivity.this, ResultActivity2.class);
                        intent.putExtra("step1", step1);
                        intent.putExtra("traveling", traveling);
                        intent.putExtra("straight", straight);
                        intent.putExtra("date", date);
                        WaitingActivity.this.startActivity(intent);

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WaitingActivity.this);
                        builder.setMessage("Analyze Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ResultRequest2 resultRequest2 = new ResultRequest2(filename, responseListener);
        RequestQueue queue = Volley.newRequestQueue(WaitingActivity.this);
        queue.add(resultRequest2);


    }


}

