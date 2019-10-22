package com.ehappy.baspost_01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide status bar
        //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_loading);

//        DisplayMetrics metrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//
//        System.out.println("手機銀幕大小為 "+metrics.widthPixels+" X "+metrics.heightPixels);

        mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 3000);
    }

    private static final int GOTO_MAIN_ACTIVITY = 0;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case GOTO_MAIN_ACTIVITY:
                    Intent intent = new Intent();
                    //將原本Activity的換成別的Activity
                    intent.setClass(LoadingActivity.this, Login2Activity.class);
                    startActivity(intent);
                    finish();
                    break;

                default:
                    break;
            }
        }

    };
}
