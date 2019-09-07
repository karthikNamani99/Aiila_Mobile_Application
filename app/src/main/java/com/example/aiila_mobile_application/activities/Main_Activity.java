package com.example.aiila_mobile_application.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.aiila_mobile_application.R;
import com.example.aiila_mobile_application.fragments.Account_Fragment;
import com.example.aiila_mobile_application.fragments.DashBoard_Fragment;
import com.example.aiila_mobile_application.fragments.General_Fragment;
import com.example.aiila_mobile_application.fragments.Help_Fragment;
import com.example.aiila_mobile_application.fragments.Notifications_Fragment;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Main_Activity extends BaseActivity{

    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private CircleImageView imgNavHeaderBg;
    CircleImageView imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;

    public static int navItemIndex = 0;

    // tags used to attach the fragments
    private static final String TAG_DASHBOARD = "dashboard";
    private static final String TAG_NOTIFICATION = "notification";

    private static final String TAG_GENERAL = "general";
    private static final String TAG_ACCOUNT = "account";
    private static final String TAG_HELP = "help";
    public static String CURRENT_TAG = TAG_DASHBOARD;

    private String[] activityTitles;

    private Handler mHandler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

        // Navigation view header
        navHeader = navigationView.getHeaderView(0);


        imgNavHeaderBg = (CircleImageView) navHeader.findViewById(R.id.img_header_bg);

        // load the store fragment by default
        navigationView.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        imgNavHeaderBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),View_UserDetails_Activity.class);
                startActivity(intent);
            }
        });


        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_DASHBOARD;
            loadHomeFragment();
        }
    }

    @Override
    public void onBackPressed() {

        doExit();
    }

    private void doExit() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                Main_Activity.this);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("No", null);

        alertDialog.setMessage("Do you want to exit?");
        alertDialog.setTitle("AppTitle");

        AlertDialog dialog = alertDialog.create();
        dialog.show();

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.darker_gray);
// Get the alert dialog buttons reference
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

        // Change the alert dialog buttons text and background color
        positiveButton.setTextColor(Color.parseColor("#FF0B8B42"));
//        positiveButton.setBackgroundColor(Color.parseColor("#FFE1FCEA"));

        negativeButton.setTextColor(Color.parseColor("#FFFF0400"));
//        negativeButton.setBackgroundColor(Color.parseColor("#FFFCB9B7"));





    }

    private void loadHomeFragment() {
        selectNavMenu();

        // set toolbar title
        setToolbarTitle();

        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();
            return;
        }

        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }


        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }


    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private Fragment getHomeFragment() {

        switch (navItemIndex) {
            case 0:
                // home
                DashBoard_Fragment dashBoard_fragment = new DashBoard_Fragment();
                return dashBoard_fragment;
            case 1:
                // home
                Notifications_Fragment notificationFragment = new Notifications_Fragment();
                return notificationFragment;
            case 2:
                // photos
                General_Fragment generalFragment = new General_Fragment();
                return generalFragment;
            case 3:
                // movies fragment
                Account_Fragment account_fragment = new Account_Fragment();
                return account_fragment;
            case 4:
                // movies fragment
                Help_Fragment help_fragment = new Help_Fragment();
                return help_fragment;

            default:
                return new Notifications_Fragment();
        }
    }
    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_dashboard:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_DASHBOARD;
                        break;
                    case R.id.nav_notification:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_NOTIFICATION;
                        break;
                    case R.id.nav_general:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_GENERAL;
                        break;
                    case R.id.nav_account:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_ACCOUNT;
                        break;
                    case R.id.nav_help:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_HELP;
                        break;
                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();

        }

}
