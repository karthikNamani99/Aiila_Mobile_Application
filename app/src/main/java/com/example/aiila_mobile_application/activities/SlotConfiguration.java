package com.example.aiila_mobile_application.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;


import com.example.aiila_mobile_application.R;

import java.util.ArrayList;
import java.util.List;

public class SlotConfiguration extends BaseActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spinner_brand, spinner_type, spinner_volume;
    TextView headerTextView;

    ImageView bottle1ImageView1, bottle2ImageView1, bottle1ImageView2, bottle2ImageView2, bottle1ImageView3, bottle2ImageView3;
    Button btn_done;

    boolean flag = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slot_configuration_main);

        showToolbar();
        setStatusBarTopColor();

        headerTextView = (TextView) findViewById(R.id.header);
        headerTextView.setText("Slot configuration");

        spinner_brand = (Spinner) findViewById(R.id.spinner_brand);
        spinner_type = (Spinner) findViewById(R.id.spinner_type);
        spinner_volume = (Spinner) findViewById(R.id.spinner_volume);

        bottle1ImageView1 = findViewById(R.id.bottle1ImageView1);
        bottle2ImageView1 = findViewById(R.id.bottle2ImageView1);
        bottle1ImageView2 = findViewById(R.id.bottle1ImageView2);
        bottle2ImageView2 = findViewById(R.id.bottle2ImageView2);
        bottle1ImageView3 = findViewById(R.id.bottle1ImageView3);
        bottle2ImageView3 = findViewById(R.id.bottle2ImageView3);

        btn_done = findViewById(R.id.slotSubmitButton);

        spinner_brand.setOnItemSelectedListener(this);
        spinner_type.setOnItemSelectedListener(this);
        spinner_volume.setOnItemSelectedListener(this);

        bottle1ImageView1.setOnClickListener(this);
        bottle2ImageView1.setOnClickListener(this);
        bottle1ImageView2.setOnClickListener(this);
        bottle2ImageView2.setOnClickListener(this);
        bottle1ImageView3.setOnClickListener(this);
        bottle2ImageView3.setOnClickListener(this);

        btn_done.setOnClickListener(this);


        // Spinner Drop down elements
        List<String> brand = new ArrayList<String>();
        brand.add("-Brand-");
        brand.add("Mecallan");
        brand.add("James Dannies");
        brand.add("Block gog");
        brand.add("Beefeater");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_spinner_item, brand);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_brand.setAdapter(dataAdapter);
        // Spinner Drop down elements
        List<String> type = new ArrayList<String>();
        type.add("-Type-");
        type.add("Whisky");
        type.add("Jin");
        type.add("Rum");
        type.add("Vodka");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_spinner_item, type);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_type.setAdapter(dataAdapter1);
        // Spinner Drop down elements
        List<String> volume = new ArrayList<String>();
        volume.add("-Volume-");
        volume.add("200ml");
        volume.add("500ml");
        volume.add("750ml");
        volume.add("1000ml");
        volume.add("1.5L");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_spinner_item, volume);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_volume.setAdapter(dataAdapter2);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.slotSubmitButton:
                Intent intent = new Intent(getApplicationContext(), Selected_Items_Activity.class);
                startActivity(intent);

                break;


            case R.id.bottle1ImageView1:

                view.setActivated(!view.isActivated());

                break;
            case R.id.bottle2ImageView1:

                view.setActivated(!view.isActivated());

                break;
            case R.id.bottle1ImageView2:

                view.setActivated(!view.isActivated());

                break;
            case R.id.bottle2ImageView2:

                view.setActivated(!view.isActivated());

                break;
            case R.id.bottle1ImageView3:

                view.setActivated(!view.isActivated());

                break;
            case R.id.bottle2ImageView3:

                view.setActivated(!view.isActivated());

                break;

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        switch (view.getId()) {

            case R.id.spinner_brand:
                String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
                break;
            case R.id.spinner_type:
                String item1 = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item1, Toast.LENGTH_LONG).show();
                break;
            case R.id.spinner_volume:
                String item2 = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item2, Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}

