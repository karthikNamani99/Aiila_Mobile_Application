package com.example.aiila_mobile_application.splash_screens_activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.aiila_mobile_application.R;
import com.example.aiila_mobile_application.activities.Login_Activity;


public class SplashActivity1 extends AppCompatActivity {

    Handler handler;
    Intent i;
    TextView btn_next, btn_skip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity1_main);

        btn_next = findViewById(R.id.btn_next);
        btn_skip = findViewById(R.id.btn_skip);

        btn_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn_skip = new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(btn_skip);
                finish();

            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent btn_next = new Intent(getApplicationContext(), SplashActivity2.class);
                startActivity(btn_next);
                finish();

            }
        });


//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                new Handler().postDelayed(new Runnable() {
//
//                    @Override
//                    public void run() {
//
//                        i = new Intent(SplashActivity1.this, SplashActivity2.class);
//                        startActivity(i);
//                        finish();
//
//                    }
//                }, 1500);
//            }
//        });


//        handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(getApplicationContext(), SplashActivity2.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 2000);


    }
}
