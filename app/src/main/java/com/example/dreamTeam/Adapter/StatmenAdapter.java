package com.example.dreamTeam.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.dreamTeam.CreateReport;
import com.example.dreamTeam.R;
import com.example.dreamTeam.Statmen;
import com.example.dreamTeam.StatmenEnum;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class StatmenAdapter implements ListAdapter {
    ArrayList<Statmen> arrayList;
    Context context;
    HashMap<String,StatmenEnum> hashMapStatments;
    public StatmenAdapter(Context context, ArrayList<Statmen> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
        hashMapStatments = new HashMap<String, StatmenEnum>();
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
        Statmen statmenDate=arrayList.get(position);
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.item_for_statmen, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView textView = v.findViewById(R.id.TextViewRefer);
                    String titl = textView.getText().toString();
                    if(hashMapStatments.get(titl)==StatmenEnum.DONE){

                    }else{
                        
                    }
                }
            });
           TextView tittle=convertView.findViewById(R.id.TextViewRefer);
            tittle.setText(statmenDate.Text);

            ImageView imgView= convertView.findViewById(R.id.imageViewIconState);
hashMapStatments.put(statmenDate.Text,statmenDate.State);
            switch (statmenDate.State) {
                case DONE:
                imgView.setImageDrawable(context.getDrawable(R.drawable.green_shape));
                    break;
                case DOWLODED:
                imgView.setImageDrawable(context.getDrawable(R.drawable.red_shape));
                    break;
                case PROCESSING:
                    imgView.setImageDrawable(context.getDrawable(R.drawable.yellow_shape));
                    break;
            }
          TextView textViewDate = convertView.findViewById(R.id.textViewTime);
            textViewDate.setText(statmenDate.simpleDate.format(new Date()));
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