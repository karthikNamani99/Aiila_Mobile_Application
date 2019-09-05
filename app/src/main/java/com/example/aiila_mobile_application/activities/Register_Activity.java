package com.example.aiila_mobile_application.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aiila_mobile_application.R;

public class Register_Activity extends AppCompatActivity {

    EditText edit_name, edit_email, edit_mobile, edit_password, edit_confirm_password;
    Button btn_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        edit_name = (EditText) findViewById(R.id.edit_name);
        edit_email = (EditText) findViewById(R.id.edit_email);
        edit_mobile = (EditText) findViewById(R.id.edit_mobile);
        edit_password = (EditText) findViewById(R.id.edit_password);
        edit_confirm_password = (EditText) findViewById(R.id.edit_confirm_password);
        //Initialization of Register Button
        btn_register = (Button) findViewById(R.id.btn_register);


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }
}
