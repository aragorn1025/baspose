package com.ehappy.baspost_01;

import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        result2bt = findViewById(R.id.button);

        datetv.setText(date);
        angle1tv.setText("Angle of your elbow: "+anglebefore+"");

        if(80<anglebefore&&anglebefore<100)
        {
            comment1tv.setText("Your posture is perfect.");
        }
        else
        {
            comment1tv.setText("Your elbow needs to be square.");
        }

        //comment1tv.setText(commentbefore);
        angle2tv.setText("1. Angle of your arm: "+angleafter+"");

        if(170<angleafter&&angleafter<180)
        {
            comment2tv.setText("Your follow through is perfect.");
        }
        else
        {
            comment2tv.setText("Your follow through should be more extended.");
        }
        //comment2tv.setText(commentafter);

        if(wrist==0)
        {
            wristtv.setText("2. Great! You have snapped your wrist.");

        }else
        {
            wristtv.setText("2. You should snap your wrist.");

        }

        result2bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mmgIntent = new Intent(ResultActivity.this,ResultActivity_mmg.class);
                ResultActivity.this.startActivity(mmgIntent);

            }
        });


    }


}
