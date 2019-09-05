package com.example.aiila_mobile_application.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.aiila_mobile_application.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashBoard_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_fragment, container, false);
        BottomNavigationView navigation = (BottomNavigationView)view.findViewById(R.id.navigation);


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(0).setChecked(true);

        loadFragment(new HomeFragment());
        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    fragment = new HomeFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.analytics:

                    fragment = new Analytics_Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.slot_configuration:

                    fragment = new Slot_Configuration_Fragment();
                    loadFragment(fragment);
                    return true;
                case R.id.control_machine:

                    fragment = new Control_machine_Fragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }


    };
}
