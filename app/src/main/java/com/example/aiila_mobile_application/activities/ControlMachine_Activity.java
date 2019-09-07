package com.example.aiila_mobile_application.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;


import androidx.viewpager.widget.ViewPager;

import com.example.aiila_mobile_application.R;

import com.example.aiila_mobile_application.adapters.ControlMachine_pagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ControlMachine_Activity extends BaseActivity implements TabLayout.BaseOnTabSelectedListener {

    TextView headerTextView;

    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controlmachine_main);

        showToolbar();
        setStatusBarTopColor();

        headerTextView = (TextView) findViewById(R.id.header);
        headerTextView.setText("Analytics");

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Machine 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Machine 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Machine 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager)findViewById(R.id.pager);

        //Creating our pager adapter

        ControlMachine_pagerAdapter adapter = new ControlMachine_pagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {



    }


}
