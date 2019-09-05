package com.example.aiila_mobile_application.splash_screens_activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aiila_mobile_application.R;
import com.example.aiila_mobile_application.activities.Login_Activity;

public class SplashActivity3 extends AppCompatActivity{

    Intent i;
    Handler handler;
    TextView btn_done;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity3_main);

        btn_done=findViewById(R.id.btn_done);



        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn_done=new Intent(getApplicationContext(), Login_Activity.class);
                startActivity(btn_done);
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
//                        i = new Intent(SplashActivity3.this, Login_Activity.class);
//                        startActivity(i);
//                        finish();
//
//                    }
//                }, 1500);
//            }
//        });

//        handler = new Handler();
//
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
//                startActivity(intent);
//                finish();
//            }
//        }, 2000);

    }


}
