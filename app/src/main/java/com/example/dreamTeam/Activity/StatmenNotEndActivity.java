package com.example.dreamTeam.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.dreamTeam.R;

public class StatmenNotEndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statmen_not_end_activiry);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle=getIntent().getExtras();
        String message = bundle.getString("AllText");
        TextView textViewAllText = findViewById(R.id.textViewAllText);
        textViewAllText.setText(textViewAllText.getText()+"\n"+message);

        TextView textViewDate = findViewById(R.id.textViewDateOpen);
        String date = bundle.getString("date");
        textViewDate.setText(textViewDate.getText()+"\t"+date);

        int curentState = bundle.getInt("valueState");
        TextView textViewStatus = findViewById(R.id.textViewStatus);
        if(curentState==1){
            textViewStatus.setText(textViewStatus.getText()+"\t"+ "в обработке");
        }else{
            textViewStatus.setText(textViewStatus.getText()+"\t"+ "ожидается подтверждение");
        }

    }

}
