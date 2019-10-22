package com.ehappy.baspost_01;

import android.content.Intent;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.andremion.floatingnavigationview.FloatingNavigationView;

public class ResultActivity2 extends AppCompatActivity {

    private TextView datetv,commenttv;

    private ImageView imgview;

    private Button result2bt;

    private FloatingNavigationView mFloatingNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result2_nav_main);

        Intent intent = getIntent();
        int step1 = intent.getIntExtra("step1",-1);
        int traveling = intent.getIntExtra("traveling",-1);
        int straight = intent.getIntExtra("straight",-1);
        String date = intent.getStringExtra("date");

        System.out.println("step1 = "+step1);
        System.out.println("traveling = "+traveling);
        System.out.println("straight = "+straight);
        System.out.println("date = "+date);

        datetv = findViewById(R.id.datetv);
        commenttv = findViewById(R.id.commenttv);
        imgview = findViewById(R.id.imgview);

        datetv.setText(date);

        if(step1 == 0)
        {
            //commenttv.setText("Step toward the basket with your right foot. When you're just a few feet from the basket, take a step toward it with our right foot. Use this step to gain distance and position yourself within easy shooting range. Dribble the ball one last time just outside your right foot.");
            //commenttv.setText("你的第一步踩錯了喔！右手上籃的收球腳需跨「右腳」出去並順勢帶動你的下一步。");

            imgview.setImageResource(R.drawable.layupcomment01);

        }
        else{

            if(traveling == 0){

                //commenttv.setText("Jump off of your left foot. As soon as your left foot lands, use it to jump in the direction of the basket. Ideally, you'll be positioned close enough to the basket that you can jump straight up to take your shot.");
                //commenttv.setText("走步違例！三步上籃中邁出第二步起跳腳「左腳」後，要順勢帶出右腳並且要在空中完成上籃動作才可。");
                imgview.setImageResource(R.drawable.layupcomment02);
            }
            else
            {

                if(straight == 2)
                {
                    //commenttv.setText("Arch your arm toward the basket. Shoot with your elbow slightly bent, so that your arm looks like the neck of a swan.");
                    //commenttv.setText("你的右手再將球拋出時，手臂需盡可能伸直介於160 ~ 180度。");
                    imgview.setImageResource(R.drawable.layupcomment04);
                }
                else
                {
                    imgview.setImageResource(R.drawable.layupcomment03);
                }

            }
        }


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
                        Intent mainIntent = new Intent(ResultActivity2.this,MainActivity.class);
                        ResultActivity2.this.startActivity(mainIntent);
                        break;

                }

                mFloatingNavigationView.close();
                return true;
            }
        });


    }
}
