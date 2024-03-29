package com.example.dreamTeam.Activity;


import android.content.Intent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import android.widget.ListView;

import com.example.dreamTeam.Adapter.CustomAdapter;
import com.example.dreamTeam.Adapter.RaitingAdapter;
import com.example.dreamTeam.DataAboutField;
import com.example.dreamTeam.LogInActiviry;
import com.example.dreamTeam.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        final ListView list =(ListView) findViewById(R.id.list);
        ArrayList<DataAboutField> arrayList = new ArrayList<DataAboutField>();
        arrayList.add(new DataAboutField("Атлас",getResources().getDrawable( R.drawable.atlas )));
        arrayList.add(new DataAboutField("Атлас",getResources().getDrawable( R.drawable.atlas )));
        arrayList.add(new DataAboutField("Атлас",getResources().getDrawable( R.drawable.atlas)));
        CustomAdapter customAdapter = new  CustomAdapter(this.getApplicationContext(),arrayList);
        list.setAdapter(customAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_gallery) {
          Intent intent =  new Intent(MainActivity.this,StatmenActivity.class);
        startActivity(intent);

        } else if (id == R.id.nav_reiting) {

            Intent intent =  new Intent(MainActivity.this, RaitingActivity.class);
            RaitingAdapter.context = this.getApplicationContext();
            startActivity(intent);
        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_out) {
            Intent inent = new Intent(MainActivity.this, LogInActiviry.class);
            startActivity(inent);
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
