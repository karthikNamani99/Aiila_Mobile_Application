package com.example.aiila_mobile_application.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.aiila_mobile_application.R;
import com.example.aiila_mobile_application.adapters.ControlMachine_pagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class Control_machine_Fragment extends Fragment implements TabLayout.BaseOnTabSelectedListener {

    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.controlmachine_fragment_main,container,false);

        tabLayout = (TabLayout)view.findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Machine 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Machine 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Machine 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager)view.findViewById(R.id.pager);

        //Creating our pager adapter

        ControlMachine_pagerAdapter adapter = new ControlMachine_pagerAdapter(getChildFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(this);
        return view;
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
