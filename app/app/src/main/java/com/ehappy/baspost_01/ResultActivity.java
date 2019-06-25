package com.ehappy.baspost_01;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class ResultActivity extends AppCompatActivity {


    private TextView datetv,angle1tv,comment1tv,angle2tv,comment2tv,wristtv;

    private Button result2bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        double anglebefore = intent.getDoubleExtra("anglebefore",-1);
        String commentbefore = intent.getStringExtra("commentbefore");

        double angleafter = intent.getDoubleExtra("angleafter",-1);
        String commentafter = intent.getStringExtra("commentafter");
        int wrist = intent.getIntExtra("wrist",-1);


        String date = intent.getStringExtra("date");


        datetv = findViewById(R.id.datetv);
        angle1tv = findViewById(R.id.angle1tv);
        angle2tv = findViewById(R.id.angle2tv);
        comment1tv = findViewById(R.id.comment1tv);
        comment2tv = findViewById(R.id.comment2tv);
        wristtv = findViewById(R.id.wristtv);

        datetv.setText(date);
        angle1tv.setText(anglebefore+"");
        comment1tv.setText(commentbefore);

        angle2tv.setText(angleafter+"");
        comment2tv.setText(commentafter);

        if(wrist==0)
        {
            wristtv.setText("good");

        }else
        {
            wristtv.setText("bad");
        }





    }


}
