package com.ehappy.baspost_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    private ImageButton class01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        class01 = findViewById(R.id.imshooting);

        class01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent classIntent = new Intent(MainActivity.this,Class01.class);
                MainActivity.this.startActivity(classIntent);

            }
        });
    }
}
