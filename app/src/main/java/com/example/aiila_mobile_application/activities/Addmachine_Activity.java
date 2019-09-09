package com.example.aiila_mobile_application.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.aiila_mobile_application.R;
import com.example.aiila_mobile_application.activities.BaseActivity;

public class Addmachine_Activity extends BaseActivity {

    TextView headerTextView;

    Button btn_done;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmachine_main);

        showToolbar();
        setStatusBarTopColor();

        headerTextView = (TextView) findViewById(R.id.header);
        headerTextView.setText("Add New Machine");

        btn_done = findViewById(R.id.btn_done);

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Machine_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }
}
