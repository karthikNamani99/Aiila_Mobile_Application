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

public class Forgot_Password_Activity extends BaseActivity implements View.OnClickListener {

    EditText edit_email, edit_mobile;
    Button btn_set_password_link, btn_otp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_main);

        btn_set_password_link = findViewById(R.id.btn_set_password_link);

        edit_email = findViewById(R.id.edit_email);

        edit_mobile = findViewById(R.id.edit_mobile);

        btn_otp = findViewById(R.id.btn_otp);

        btn_set_password_link.setOnClickListener(this);
        btn_otp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_set_password_link:

                Toast.makeText(getApplicationContext(),"link sended successfully",Toast.LENGTH_LONG).show();
                Intent password_link_intent=new Intent(getApplicationContext(),Login_Activity.class);
                password_link_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(password_link_intent);

                break;

            case R.id.btn_otp:
                Intent otp_intent=new Intent(getApplicationContext(),Mobile_Verification_Activity.class);
                otp_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(otp_intent);

                break;
        }
    }
}
