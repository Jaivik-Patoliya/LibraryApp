package com.jaivikpatoliya.library;

import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.annotation.SuppressLint;
import android.content.Context;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;


import com.google.android.material.navigation.NavigationView;

import java.util.Objects;


public class Home_activity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    CoordinatorLayout coordinatorLayout;
    FrameLayout framelayout;
    NavigationView navigationview;
    String titlename;
    SharedPreferences sharedPreferences;
    MenuItem previousMenuItem = null;

    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = findViewById(R.id.drawerlayout);
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        framelayout = findViewById(R.id.frame);
        navigationview = findViewById(R.id.Navigationview);
        sharedPreferences = getSharedPreferences(getString(R.string.Preference_file_name), Context.MODE_PRIVATE);
         titlename = sharedPreferences.getString("Title", titlename);
         setTitle(titlename);
        //setuptoolbar();
        ActionBarDrawerToggle DrawerToggle = new ActionBarDrawerToggle(Home_activity.this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(DrawerToggle);
        DrawerToggle.syncState();
        opendashbord();
        navigationview.setNavigationItemSelectedListener(item -> {
            if(previousMenuItem != null){
                previousMenuItem.setChecked(false);
            }
            item.setCheckable(true);
            item.setChecked(true);
            previousMenuItem = item;

            switch(item.getItemId()){
                case R.id.dashbord :
                    opendashbord();
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ProfileFragment()).commit();
                    setTitle("Profile");
                    drawerLayout.closeDrawers();
                    return true;
                case R.id.about:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, new AboutFragment()).commit();
                    setTitle("About App");
                    drawerLayout.closeDrawers();
                    return true;
                default:
                    return true;
            }
        });
    }
    public void opendashbord(){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new dashbordFragment()).commit();
        navigationview.setCheckedItem(R.id.dashbord);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
       if(!Objects.equals(getSupportFragmentManager().findFragmentById(R.id.frame), new dashbordFragment())){
           opendashbord();
           setTitle(titlename);
           previousMenuItem.setChecked(true);
       }
       else {
           super.onBackPressed();
       }
    }
}
