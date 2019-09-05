package com.example.aiila_mobile_application.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aiila_mobile_application.R;

public class SetPassword_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText edit_password, edit_confirm_password;
    Button btn_submit;

    TextView btn_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setpassword_main);

        btn_login=findViewById(R.id.btn_login);
        btn_submit=findViewById(R.id.btn_submit);
        edit_password=findViewById(R.id.edit_password);
        edit_confirm_password=findViewById(R.id.edit_confirm_password);

        btn_login.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_login:
                Intent intent = new Intent(getApplicationContext(), Login_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;
            case R.id.btn_submit:

                Intent intent1 = new Intent(getApplicationContext(), Login_Activity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);

                break;
        }
    }
}
