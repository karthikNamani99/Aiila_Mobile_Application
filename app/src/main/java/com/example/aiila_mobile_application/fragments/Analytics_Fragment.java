package com.example.aiila_mobile_application.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiila_mobile_application.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Analytics_Fragment extends Fragment {

    String[] name = {
            "Total Drinks Sold", "Revenue", "Profit"};
    String[] price = {
            "260", "550", "3400"
    };
    RecyclerView quickInfoRecyclerView;
    MoviesAdapter mAdapter;
    TextView headerTextView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.analytics_fragment_main,container,false);

        quickInfoRecyclerView = (RecyclerView)view.findViewById(R.id.quick_info_recycler_view);
        BarChart chart =view.findViewById(R.id.barchart);

        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(555f, 0));
        NoOfEmp.add(new BarEntry(640f, 1));
        NoOfEmp.add(new BarEntry(933f, 2));
        NoOfEmp.add(new BarEntry(1000f, 3));
        NoOfEmp.add(new BarEntry(1109f, 4));
        NoOfEmp.add(new BarEntry(1207f, 5));
//        NoOfEmp.add(new BarEntry(807f, 6));
//        NoOfEmp.add(new BarEntry(507f, 7));


        ArrayList year = new ArrayList();
//
        year.add("1W");
        year.add("1M");
        year.add("1Y");
        year.add("1W");
        year.add("1M");
        year.add("1Y");
//        year.add("2014");
//        year.add("2015");


        BarDataSet bardataset = new BarDataSet(NoOfEmp, "Days/Months/years");
        chart.animateY(1000);
        BarData data = new BarData(year, bardataset);
        bardataset.setColors(ColorTemplate.JOYFUL_COLORS);

        chart.setData(data);

        PieChart pieChart =view.findViewById(R.id.piechart);
        ArrayList NoOfEmp1 = new ArrayList();

        NoOfEmp1.add(new Entry(945f, 0));
        NoOfEmp1.add(new Entry(1040f, 1));
        NoOfEmp1.add(new Entry(1133f, 2));
        NoOfEmp1.add(new Entry(1240f, 3));
        NoOfEmp1.add(new Entry(1369f, 4));
        NoOfEmp1.add(new Entry(1487f, 5));
//
        PieDataSet dataSet = new PieDataSet(NoOfEmp1, "");

        ArrayList year1 = new ArrayList();

        year1.add("18%");
        year1.add("9%");
        year1.add("12%");
        year1.add("5%");
        year1.add("22%");
        year1.add("10%");
        PieData data1 = new PieData(year1, dataSet);
        pieChart.setData(data1);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.setDrawHoleEnabled(false);
        pieChart.animateXY(1000, 1000);

        mAdapter = new MoviesAdapter(name, price);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        quickInfoRecyclerView.setLayoutManager(layoutManager);
        quickInfoRecyclerView.setAdapter(mAdapter);
        return view;
    }

    public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

        private String[] nmaes, prices;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView title, year, genre;

            public MyViewHolder(View view) {
                super(view);
                title = (TextView) view.findViewById(R.id.quickInfoTv);
                year = (TextView) view.findViewById(R.id.quickInfoPriceTv);
            }
        }


        public MoviesAdapter(String[] name, String[] price) {
            nmaes = name;
            prices = price;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.quick_info_recycler_item, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {

            holder.title.setText(nmaes[position]);
            holder.year.setText(prices[position]);
        }

        @Override
        public int getItemCount() {
            return nmaes.length;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case android.R.id.home:

                getActivity().finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
