package com.example.dreamTeam.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.dreamTeam.Activity.AssessmentActyvity;
import com.example.dreamTeam.Activity.StatmenNotEndActivity;
import com.example.dreamTeam.ComponyRaiting;
import com.example.dreamTeam.R;
import com.example.dreamTeam.Statmen;
import com.example.dreamTeam.StatmenEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RaitingAdapter  implements ListAdapter {
    ArrayList<ComponyRaiting> arrayList;
  public  static   Context context;

    public RaitingAdapter(Context context, ArrayList<ComponyRaiting> arrayList) {
        this.arrayList=arrayList;
        this.context=context;

    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ComponyRaiting statmenDate=arrayList.get(position);
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.layout_item_raiting, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
           ImageView img = convertView.findViewById(R.id.imageViewDisplayIcon);
           TextView txtViwTitle = convertView.findViewById(R.id.TextViewReferT);

TextView textView = convertView.findViewById(R.id.textViewReiting11);
           txtViwTitle.setText(statmenDate.TitleCompony);
            textView.setText(statmenDate.Raiting);

        }
        return convertView;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
}