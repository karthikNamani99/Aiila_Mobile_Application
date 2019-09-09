package com.example.aiila_mobile_application.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.aiila_mobile_application.R;

public class Modify_user_Details_Activity extends BaseActivity {

    TextView headerTextView;
    Button submit_button;
    EditText edit_password,edit_email,edit_mobile,edit_name;
    Spinner spinner_usertype;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_user_details_main);

        showToolbar();
        setStatusBarTopColor();

        headerTextView = (TextView) findViewById(R.id.header);
        headerTextView.setText("Modify User details");

        submit_button=findViewById(R.id.btn_submit);

        edit_password=findViewById(R.id.edit_password);
        edit_email=findViewById(R.id.edit_email);
        edit_mobile=findViewById(R.id.edit_mobile);
        edit_name=findViewById(R.id.edit_name);

        spinner_usertype=findViewById(R.id.spinner_usertype);


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Users_Activity.class);
                intent.setFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Successfull change the user details",Toast.LENGTH_LONG).show();
            }
        });





    }
}
