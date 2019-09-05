package com.example.aiila_mobile_application.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aiila_mobile_application.R;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText edit_email,edit_password;
    Button btn_continue,btn_google,btn_facebook;
    TextView btn_register,btn_reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        edit_email=(EditText)findViewById(R.id.edit_email);
        edit_password=(EditText)findViewById(R.id.edit_password);

        btn_continue=(Button)findViewById(R.id.btn_continue);
        btn_google=(Button)findViewById(R.id.btn_google);
        btn_facebook=(Button)findViewById(R.id.btn_facebook);


        btn_register=findViewById(R.id.btn_register);
        btn_reset=findViewById(R.id.btn_reset);

        btn_continue.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        btn_reset.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_continue:

                Intent continue_intent=new Intent(getApplicationContext(),Main_Activity.class);
                continue_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(continue_intent);

                break;
            case R.id.btn_register:

                Intent register_intent=new Intent(getApplicationContext(),Register_Activity.class);
                register_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(register_intent);

                break;
            case R.id.btn_reset:

                Intent reset_intent=new Intent(getApplicationContext(),Forgot_Password_Activity.class);
                reset_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(reset_intent);

                break;
        }
    }
}
