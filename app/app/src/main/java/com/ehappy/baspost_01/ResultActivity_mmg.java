package com.ehappy.baspost_01;

import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity_mmg extends AppCompatActivity {


    private TextView mmgtv,commenttv,datetv;

    private Button result1bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_mmg);

        Intent intent = getIntent();
        double mmg = intent.getDoubleExtra("mmg",-1);

        String date = intent.getStringExtra("date");

        mmgtv = findViewById(R.id.mmgtv);
        commenttv = findViewById(R.id.commenttv);
        result1bt = findViewById(R.id.button);


        mmgtv.setText("Mean Power : "+mmg+"");
        commenttv.setText("Comment : 出力不夠，再接再厲。");

        //datetv = findViewById(R.id.datetv);
        //datetv.setText(date);

        result1bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mmgIntent = new Intent(ResultActivity_mmg.this,ResultActivity.class);
                ResultActivity_mmg.this.startActivity(mmgIntent);

            }
        });





    }


}
