package com.example.aiila_mobile_application.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.aiila_mobile_application.R;
import com.example.aiila_mobile_application.activities.Users_List;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.MyViewHolder>{

    Context context;
    List<Users_List> userslist = new ArrayList<>();


    public UsersListAdapter(Context context, List<Users_List> userslist) {
        this.context = context;
        this.userslist = userslist;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView user_email, uaser_name,user_mobile,user_type,delete_icon;
        public ImageView user_profile;

        public MyViewHolder(View view) {
            super(view);
            user_email = (TextView) view.findViewById(R.id.user_email);
            uaser_name = (TextView) view.findViewById(R.id.user_name);
            user_mobile = (TextView) view.findViewById(R.id.user_mobile);
            user_type = (TextView) view.findViewById(R.id.user_type);
            user_profile = (CircleImageView) view.findViewById(R.id.user_profile);
            delete_icon = (TextView) view.findViewById(R.id.delete_icon);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_ist_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Users_List userlist = userslist.get(position);
        holder.user_email.setText(userlist.getEmail());
        holder.uaser_name.setText(userlist.getName());
        holder.user_mobile.setText(userlist.getMobile());
        holder.user_type.setText(userlist.getUser_type());
        holder.user_profile.setImageResource(userlist.getProfile());

    }

    @Override
    public int getItemCount() {
        return userslist.size();
    }

}
