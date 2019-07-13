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

import com.example.dreamTeam.Activity.StatmenNotEndActivity;
import com.example.dreamTeam.R;
import com.example.dreamTeam.Statmen;
import com.example.dreamTeam.StatmenEnum;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class StatmenAdapter implements ListAdapter {
    ArrayList<Statmen> arrayList;
    Context context;
    HashMap<String,Statmen> hashMapStatments;
    public StatmenAdapter(Context context, ArrayList<Statmen> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
        hashMapStatments = new HashMap<String, Statmen>();
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
                   Statmen statmen =  hashMapStatments.get(titl);
                    if(statmen.State==StatmenEnum.DONE){

                    }else{
                        Intent intent = new Intent(context, StatmenNotEndActivity.class);
                        intent.putExtra("AllText",statmen.fullText);
                        intent.putExtra("date",statmen.simpleDate.format(new Date()));
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("valueState",statmen.State.ordinal());
                        context.startActivity(intent);
                    }
                }
            });
           TextView tittle=convertView.findViewById(R.id.TextViewRefer);
            tittle.setText(statmenDate.Text);

            ImageView imgView= convertView.findViewById(R.id.imageViewIconState);
hashMapStatments.put(statmenDate.Text,statmenDate);
            switch (statmenDate.State) {
                case DONE:
                imgView.setImageDrawable(context.getDrawable(R.drawable.green_shape));
                    break;
                case EXPECTS:
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