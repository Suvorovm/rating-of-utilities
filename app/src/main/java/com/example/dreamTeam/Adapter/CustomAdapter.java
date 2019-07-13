package com.example.dreamTeam.Adapter;

import android.content.Context;


import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.dreamTeam.CreateReport;
import com.example.dreamTeam.DataAboutField;
import com.example.dreamTeam.MainActivity;
import com.example.dreamTeam.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public  class CustomAdapter implements ListAdapter {
    ArrayList<DataAboutField> arrayList;
    Context context;
    public CustomAdapter(Context context, ArrayList<DataAboutField> arrayList) {
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
        DataAboutField subjectData=arrayList.get(position);
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.item_list, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView image = v.findViewById(R.id.imageViewDisplayIcon);
                    Intent intent = new Intent(context.getApplicationContext(), CreateReport.class);
                    Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
                    ByteArrayOutputStream bs = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bs);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("byteArray", bs.toByteArray());
                    context.startActivity(intent);

                }
            });

            TextView tittle=convertView.findViewById(R.id.TextView);
            ImageView imag=convertView.findViewById(R.id.imageViewDisplayIcon);

           // TextView tittle=convertView.findViewById(R.id.NameOfAplicathion);
            ImageView img=convertView.findViewById(R.id.imageViewDisplayIcon);
            tittle.setText(subjectData.SubjectName);

            img.setImageDrawable(subjectData.Link);
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