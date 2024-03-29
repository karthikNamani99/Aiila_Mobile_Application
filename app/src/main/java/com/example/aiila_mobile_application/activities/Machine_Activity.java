package com.example.aiila_mobile_application.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.aiila_mobile_application.R;

public class Machine_Activity extends BaseActivity {

    GridView invGridView;
    ImageView addImageView;
    String[] machine_list = {"Machine 1", "Machine 2"};
    TextView headerTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machine_main);

        showToolbar();
        setStatusBarTopColor();

        headerTextView = (TextView) findViewById(R.id.header);
        headerTextView.setText("Machine");

        invGridView = (GridView) findViewById(R.id.inv_man_grid_view);
        addImageView = (ImageView) findViewById(R.id.addImageView);
        addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Addmachine_Activity.class);
                startActivity(i);
            }
        });
        invGridView.setAdapter(new Machine_Activity.CustomAdapter(this, machine_list));

    }

    public class CustomAdapter extends BaseAdapter {

        String[] result;
        Context context;
        private LayoutInflater inflater = null;

        public CustomAdapter(Machine_Activity mainActivity, String[] osNameList) {
            // TODO Auto-generated constructor stub
            result = osNameList;
            context = mainActivity;
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

        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            Holder holder = new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.machine_additem_main, null);
            holder.os_text = (TextView) rowView.findViewById(R.id.btn_addmachine);





            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(getApplicationContext(), Addmachine_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(intent);
                }
            });

            return rowView;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case android.R.id.home:

                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
