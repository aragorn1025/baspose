package com.ehappy.baspost_01;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.andremion.floatingnavigationview.FloatingNavigationView;

public class MainActivity extends AppCompatActivity {


    private ImageButton class01,class02,class03;

    public static int type = -1;

    private FloatingNavigationView mFloatingNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_nav_main);

        class01 = findViewById(R.id.imshooting);
        class02 = findViewById(R.id.imlayup);
//        class03 = findViewById(R.id.imdribble);

        class01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent classIntent = new Intent(MainActivity.this,Class01.class);
                type = 0;
                MainActivity.this.startActivity(classIntent);
            }
        });

        class02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent classIntent = new Intent(MainActivity.this,Class02.class);


                MainActivity.this.startActivity(classIntent);
            }
        });

//        class03.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent classIntent = new Intent(MainActivity.this,Class01.class);
//
//                type = 3;
//                MainActivity.this.startActivity(classIntent);
//            }
//        });

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
                        Intent mainIntent = new Intent(MainActivity.this,MainActivity.class);
                        MainActivity.this.startActivity(mainIntent);
                        break;

                }

                mFloatingNavigationView.close();
                return true;
            }
        });
    }


}
