package com.ehappy.baspost_01;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Class02 extends AppCompatActivity {

    private ImageButton rightbt,leftbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class02);

        rightbt = findViewById(R.id.layupRight);
        leftbt = findViewById(R.id.layupLeft);

        rightbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent classIntent = new Intent(Class02.this,LayupClass_Right.class);
                MainActivity.type = 1;
                Class02.this.startActivity(classIntent);
            }
        });

        leftbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent classIntent = new Intent(Class02.this,LayupClass_Right.class);
                MainActivity.type = 2;
                Class02.this.startActivity(classIntent);
            }
        });
    }
}
