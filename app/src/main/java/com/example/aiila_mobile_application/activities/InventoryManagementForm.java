package com.example.aiila_mobile_application.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;


import com.example.aiila_mobile_application.R;

import java.util.ArrayList;

public class InventoryManagementForm extends BaseActivity {


    Spinner brandSpinner, type_spinner, volume_spinner, cost_price_spinner, selling_price_30ml_spinner,
            selling_price_45ml_spinner, selling_price_60ml_spinner, discounts_spinner;
    Button invFormSubmitButton;
    ArrayList<String> brandList, brandIdList, typeList, typeIdList, volumeList, volumeIdList, priceList, priceIdList,
            sp30List, sp30IdList, sp45List, sp45IdList, sp60List, sp60IdList, discountList, discountIdList;
    TextView headerTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_management_form);

        showToolbar();
        setStatusBarTopColor();

        headerTextView = (TextView) findViewById(R.id.header);
        headerTextView.setText("Inventory Management Form");

        inflateIds();
        spinnerData();

    }

    private void spinnerData() {

        brandList = new ArrayList<>();
        brandIdList = new ArrayList<>();
        typeList = new ArrayList<>();
        typeIdList = new ArrayList<>();
        volumeList = new ArrayList<>();
        volumeIdList = new ArrayList<>();
        priceList = new ArrayList<>();
        priceIdList = new ArrayList<>();
        sp30IdList = new ArrayList<>();
        sp30List = new ArrayList<>();
        sp45IdList = new ArrayList<>();
        sp45List = new ArrayList<>();
        sp60IdList = new ArrayList<>();
        sp60List = new ArrayList<>();
        discountIdList = new ArrayList<>();
        discountList = new ArrayList<>();
        brandList.add("Brand");
        typeList.add("Type");
        volumeList.add("Volume");
        priceList.add("Cost Price");
        sp30List.add("Selling Price(30ml)");
        sp45List.add("Selling Price(45ml)");
        sp60List.add("Selling Price(60ml)");
        discountList.add("Discounts");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, R.layout.simple_spinner_item, brandList);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                this, R.layout.simple_spinner_item, typeList);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this, R.layout.simple_spinner_item, volumeList);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        volume_spinner.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
                this, R.layout.simple_spinner_item, priceList);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        cost_price_spinner.setAdapter(adapter3);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(
                this, R.layout.simple_spinner_item, sp30List);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        selling_price_30ml_spinner.setAdapter(adapter4);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(
                this, R.layout.simple_spinner_item, sp45List);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        selling_price_45ml_spinner.setAdapter(adapter5);

        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(
                this, R.layout.simple_spinner_item, sp60List);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        selling_price_60ml_spinner.setAdapter(adapter6);

        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(
                this, R.layout.simple_spinner_item, discountList);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        discounts_spinner.setAdapter(adapter7);


    }

    private void inflateIds() {

        brandSpinner = (Spinner) findViewById(R.id.spinner_brand);
        type_spinner = (Spinner) findViewById(R.id.spinner_type);
        volume_spinner = (Spinner) findViewById(R.id.spinner_volume);
        cost_price_spinner = (Spinner) findViewById(R.id.spinner_costprice);
        selling_price_30ml_spinner = (Spinner) findViewById(R.id.spinner_selling_price30ml);
        selling_price_45ml_spinner = (Spinner) findViewById(R.id.spinner_selling_price45ml);
        selling_price_60ml_spinner = (Spinner) findViewById(R.id.spinner_selling_price60ml);
        discounts_spinner = (Spinner) findViewById(R.id.spinner_discounts);
        invFormSubmitButton = (Button) findViewById(R.id.slotSubmitButton);
    }

}
