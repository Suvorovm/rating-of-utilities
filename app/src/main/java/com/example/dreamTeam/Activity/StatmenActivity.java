package com.example.dreamTeam.Activity;

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

import com.example.dreamTeam.Adapter.StatmenAdapter;
import com.example.dreamTeam.R;
import com.example.dreamTeam.Statmen;
import com.example.dreamTeam.StatmenEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class StatmenActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public  static  String first =
            "У нас пяти этажный двух подъездный дом(14 лет). В конце декабря 2018 года затопило цокольный этаж канализационными отходами.Лишь 4 января мы смогли дозвонится до управляющей компании «Комфорт»,которая обслуживает наш дом. Сначала они говорили ,что выходные,теперь они не могут найти хозяина цокольного этажа,хотя стало известно,что он в декабре скончался.Аварийная служба тоже не может попасть в цоколь,запах стоит не только в подъезде но и в квартирах,как быть? Помогите разобраться. Мы будем вам очень благодарны.";
    public  static  String second ="Здравствуйте! Такая ситуация: живём на 4 этаже, на 1 этаже не работает вентканал в ванной, жильцы обратились в управляющую компанию,ншли засор на нашем этаже, теперь просят доступ ломать стену, мы только закончили дорогостоящий ремонт. Насколько мне известно пробивать засор должны с чердака, раз мы не даем доступ уже 4 дня назад отключили газ и сказали не подключать пока не устранят засор. ";
    public  static  String third = "Мой дом построен в 1974 году, а кап. ремонт только в 2021. Моя квартира боковая на 11 этаже и у меня очень холодно. Температура в комнате редко когда соответствует нормативам в 20 градусов. Плюс в двух углах и посреди одной стены комнаты начали ползти приличные трещины из-за которых становится еще холоднее. Я боюсь до капремонта я не дотяну, либо замерзну, либо на меня соседи сверху рухнут.";
            ;
            public  final int numberOFSymbols = 33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statmen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        final ListView list =(ListView) findViewById(R.id.liststatmen);
        ArrayList<Statmen> arrayList = new ArrayList<Statmen>();
        String first1 = first.substring(0, Math.min(first.length(), numberOFSymbols))+ "...";
        String second2 = second.substring(0, Math.min(second.length(), numberOFSymbols))+ "...";
        String third3 = third.substring(0, Math.min(third.length(), numberOFSymbols))+ "...";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("10.06.2019");

        arrayList.add(new Statmen(first1, StatmenEnum.DONE,simpleDateFormat,first));
        arrayList.add(new Statmen(second2,StatmenEnum.PROCESSING,simpleDateFormat,second));
        arrayList.add(new Statmen(third3,StatmenEnum.DOWLODED,simpleDateFormat,third));

        StatmenAdapter statmenAdapter = new StatmenAdapter(this.getApplicationContext(),arrayList);
        list.setAdapter(statmenAdapter);
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
        getMenuInflater().inflate(R.menu.statmen, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
