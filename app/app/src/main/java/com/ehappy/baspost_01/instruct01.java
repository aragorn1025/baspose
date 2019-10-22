package com.ehappy.baspost_01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class instruct01 extends AppCompatActivity {

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruct01);

        next = findViewById(R.id.nextbt);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextInstruction();

            }
        });
    }

    public void nextInstruction()
    {
//        Intent captureIntent = new Intent(instruct01.this,CaptureVideoActivity.class);
//        instruct01.this.startActivity(captureIntent);

    }
}
