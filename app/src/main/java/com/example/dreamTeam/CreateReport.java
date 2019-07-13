package com.example.dreamTeam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class CreateReport extends AppCompatActivity {

    private static final int SOME_CODE = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_report);
        if (getIntent().hasExtra("byteArray")) {
            ImageView imageView = findViewById(R.id.imageViewDisplayIcon2);
            Bitmap bitmam = BitmapFactory.decodeByteArray(
                    getIntent().getByteArrayExtra("byteArray"), 0, getIntent().getByteArrayExtra("byteArray").length);
            imageView.setImageBitmap(bitmam);
        }
    }



    public void attach(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);

        intent.setType("image/*");
        startActivityForResult(intent, SOME_CODE);
    }
}
