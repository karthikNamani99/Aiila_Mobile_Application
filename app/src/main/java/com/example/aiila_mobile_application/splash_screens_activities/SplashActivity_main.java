package com.example.aiila_mobile_application.splash_screens_activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aiila_mobile_application.R;

public class SplashActivity_main extends AppCompatActivity {

    Intent i;
    Button letsStartButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity_main);

        letsStartButton = (Button) findViewById(R.id.letsStartButton);
        letsStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = new Intent(SplashActivity_main.this, SplashActivity1.class);
                startActivity(i);
                finish();
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        i = new Intent(SplashActivity_main.this, SplashActivity1.class);
                        startActivity(i);
                        finish();

                    }
                }, 2000);
            }
        });
    }
}
