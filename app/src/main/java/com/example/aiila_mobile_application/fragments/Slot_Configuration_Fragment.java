package com.example.aiila_mobile_application.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aiila_mobile_application.R;
import com.example.aiila_mobile_application.activities.Selected_Items_Activity;

import java.util.ArrayList;
import java.util.List;

public class Slot_Configuration_Fragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spinner_brand, spinner_type, spinner_volume;
    Button btn_done;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.slot_configuration_fragment_main, container, false);

        spinner_brand = (Spinner) view.findViewById(R.id.spinner_brand);
        spinner_type = (Spinner) view.findViewById(R.id.spinner_type);
        spinner_volume = (Spinner) view.findViewById(R.id.spinner_volume);
        btn_done = view.findViewById(R.id.slotSubmitButton);


        spinner_brand.setOnItemSelectedListener(this);
        spinner_type.setOnItemSelectedListener(this);
        spinner_volume.setOnItemSelectedListener(this);

        btn_done.setOnClickListener(this);


        // Spinner Drop down elements
        List<String> brand = new ArrayList<String>();
        brand.add("-Brand-");
        brand.add("Mecallan");
        brand.add("James Dannies");
        brand.add("Block gog");
        brand.add("Beefeater");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), R.layout.simple_spinner_item, brand);

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
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity(), R.layout.simple_spinner_item, type);

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
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getActivity(), R.layout.simple_spinner_item, volume);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_volume.setAdapter(dataAdapter2);

        return view;
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.slotSubmitButton:
                Intent intent = new Intent(getActivity(), Selected_Items_Activity.class);
//                intent.putExtra("data",String.valueOf(spinner_brand.getSelectedItem()));
//                intent.putExtra("data",String.valueOf(spinner_type.getSelectedItem()));
//                intent.putExtra("data",String.valueOf(spinner_volume.getSelectedItem()));
                startActivity(intent);
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
