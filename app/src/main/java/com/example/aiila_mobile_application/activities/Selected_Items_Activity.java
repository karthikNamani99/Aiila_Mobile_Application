package com.example.aiila_mobile_application.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aiila_mobile_application.R;

public class Selected_Items_Activity extends BaseActivity {

    TextView headerTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_list_items);

        showToolbar();
        setStatusBarTopColor();
        headerTextView = (TextView) findViewById(R.id.header);
        headerTextView.setText("Inventory Management");


    }


}
