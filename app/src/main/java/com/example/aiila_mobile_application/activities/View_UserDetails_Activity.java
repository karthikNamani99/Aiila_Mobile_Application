package com.example.aiila_mobile_application.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.aiila_mobile_application.R;

public class View_UserDetails_Activity extends BaseActivity {

    TextView headerTextView;
    Button btn_edit;
    TextView user_name,user_email,user_mobile,user_type;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewuser_deatails_main);

        showToolbar();
        setStatusBarTopColor();

        headerTextView = (TextView) findViewById(R.id.header);
        headerTextView.setText("View User Details");

        btn_edit=findViewById(R.id.btn_edit);

        user_name=findViewById(R.id.user_name);
        user_email=findViewById(R.id.user_email);
        user_mobile=findViewById(R.id.user_mobile);
        user_type=findViewById(R.id.user_type);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Modify_user_Details_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });


    }
}
