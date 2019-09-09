package com.example.aiila_mobile_application.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aiila_mobile_application.R;
import com.example.aiila_mobile_application.adapters.UsersListAdapter;

import java.util.ArrayList;
import java.util.List;

public class Users_Activity extends BaseActivity {
    ImageView addImageView;

    private List<Users_List> userslist = new ArrayList<>();
    private RecyclerView recyclerView;
    TextView headerTextView;
    private UsersListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.users_main);
        showToolbar();
        setStatusBarTopColor();

        headerTextView = (TextView) findViewById(R.id.header);
        headerTextView.setText("Users");
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        addImageView = (ImageView) findViewById(R.id.addImageView);

        mAdapter = new UsersListAdapter(this,userslist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        addImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Modify_user_Details_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        prepareUserdata();
    }

    private void prepareUserdata() {

        Users_List userlist = new Users_List("ashish@gmail.com", "Ashish","9876543210","Owner", R.drawable.img3);
        userslist.add(userlist);

        userlist = new Users_List("anish@gmail.com", "Anish kumar","9876543210","Manager", R.drawable.img3);
        userslist.add(userlist);

        userlist = new Users_List("alok@gmail.com", "Alok","9876543210","Bartender", R.drawable.img3);
        userslist.add(userlist);
    }
}
