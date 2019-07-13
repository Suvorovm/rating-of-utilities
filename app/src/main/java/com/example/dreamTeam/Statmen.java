package com.example.dreamTeam;

import android.graphics.drawable.Drawable;

import java.text.SimpleDateFormat;


public class Statmen {

    public  String Text;
    public  StatmenEnum State;
    public SimpleDateFormat simpleDate;
    public  String fullText;
    public  Statmen(String text,StatmenEnum State,SimpleDateFormat  simpleDate,String fullText){
        this.Text = text;
        this.State = State;
        this.simpleDate = simpleDate;
        this.fullText = fullText;
    }
}
