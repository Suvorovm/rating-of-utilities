package com.example.dreamTeam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LogInActiviry extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_start);
    }


    public void registration(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText("Регистрация");
    }


    public void enter(View view) {
        TextView textView = findViewById(R.id.textView2);
        textView.setText("Вошел");
        String password = "";
        String login = "";
        Intent Main = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(Main);


    }
}
