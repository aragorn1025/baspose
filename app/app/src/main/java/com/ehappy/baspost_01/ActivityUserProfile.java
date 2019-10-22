package com.ehappy.baspost_01;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityUserProfile extends AppCompatActivity {
    private TextView textView;

    private Button homebt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        homebt = findViewById(R.id.homebt);

        textView = (TextView) findViewById(R.id.username);

        Intent intent = getIntent();

        textView.setText(intent.getStringExtra(Login2Activity.KEY_USERNAME)+" !");

        homebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(ActivityUserProfile.this,MainActivity.class);
                ActivityUserProfile.this.startActivity(registerIntent);

            }
        });
    }


}
