package com.example.rsa_rental_service_application;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

public class testing extends AppCompatActivity {
ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        imageview=findViewById(R.id.imageView3);
        Intent i=getIntent();
        String image=i.getStringExtra("bitmap");
        try{
            byte [] encodeByte= Base64.decode(image,Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            imageview.setImageBitmap(bitmap);

        }catch(Exception e){
            e.getMessage();

        }
    }
}
