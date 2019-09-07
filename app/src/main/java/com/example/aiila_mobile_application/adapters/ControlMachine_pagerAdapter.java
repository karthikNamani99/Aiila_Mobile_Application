package com.example.aiila_mobile_application.adapters;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.aiila_mobile_application.fragments.Machine_One;
import com.example.aiila_mobile_application.fragments.Machine_Three;
import com.example.aiila_mobile_application.fragments.Machine_Two;

public class ControlMachine_pagerAdapter extends FragmentPagerAdapter {

    int tabCount;



    public ControlMachine_pagerAdapter(FragmentManager fragmentManager, int tabCount) {
        super(fragmentManager);

        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Machine_One tab1 = new Machine_One();
                return tab1;
            case 1:
                Machine_Two tab2 = new Machine_Two();
                return tab2;
            case 2:
                Machine_Three tab3 = new Machine_Three();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;

}
}
