package com.example.aiila_mobile_application.activities;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aiila_mobile_application.R;

public class HomeFragment extends Fragment {

    GridView homeGridView;

    int[] images = {R.mipmap.slotconfig, R.mipmap.analytics, R.mipmap.diagnostics, R.mipmap.inventorymanagement, R.mipmap.usermanagement, R.mipmap.controlmachine, R.mipmap.machineconfiguration};
    String[] names = {"Slot Configuration", "Analytics", "Diagnostics", "Inventory Management", "User Management", "Control Machine", "Machine Configuration"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        homeGridView = (GridView)view.findViewById(R.id.home_grid_view);
        homeGridView.setAdapter(new CustomAdapter(this, names, images));

        return view;
    }

    private class CustomAdapter extends BaseAdapter {
        String[] result;
        Context context;
        int[] imageId;
        private LayoutInflater inflater = null;

        public CustomAdapter(HomeFragment main_activity, String[] osNameList, int[] images) {
            // TODO Auto-generated constructor stub
            result = osNameList;
            context = main_activity;
            imageId = images;
            inflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }



        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return result.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public class Holder {
            TextView os_text;
            ImageView os_image;

        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            Holder holder = new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.home_grid_item, null);
            holder.os_text = (TextView) rowView.findViewById(R.id.home_item_textView);
            holder.os_image = (ImageView) rowView.findViewById(R.id.home_item_image_view);


            holder.os_text.setText(result[position]);
            holder.os_image.setImageResource(imageId[position]);


            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    if (position == 0) {
                        Intent i = new Intent(getActivity(), SlotConfiguration.class);
                        startActivity(i);
                    } else if (position == 1) {
                        Intent i = new Intent(getActivity(), SlotConfiguration.class);
                        startActivity(i);
                    } else if (position == 3) {
                        Intent i = new Intent(getActivity(), SlotConfiguration.class);
                        startActivity(i);
                    }

                    Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_SHORT).show();
                }
            });

            return rowView;
        }

    }
}
