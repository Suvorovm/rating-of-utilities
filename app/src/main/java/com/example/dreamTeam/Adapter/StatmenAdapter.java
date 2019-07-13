package com.example.dreamTeam.Adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.dreamTeam.R;
import com.example.dreamTeam.Statmen;
import com.example.dreamTeam.StatmenEnum;

import java.util.ArrayList;

public class StatmenAdapter implements ListAdapter {
    ArrayList<Statmen> arrayList;
    Context context;
    public StatmenAdapter(Context context, ArrayList<Statmen> arrayList) {
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
        Statmen statmenDate=arrayList.get(position);
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.item_for_statmen, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
           TextView tittle=convertView.findViewById(R.id.TextViewRefer);
            tittle.setText(statmenDate.Text);

            ImageView imgView= convertView.findViewById(R.id.imageViewIconState);

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
           // imag.setImageDrawable(statmenDate.Link);
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