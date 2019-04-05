package com.example.rsa_rental_service_application;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Last extends AppCompatActivity {
ImageView imageView;
TextView textView,t1,t2,t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        imageView=findViewById(R.id.album_display);
        textView=findViewById(R.id.album_title);
        t1=findViewById(R.id.textView17);
        t2=findViewById(R.id.textView18);
        t3=findViewById(R.id.textView19);
        t4=findViewById(R.id.textView20);
        String image_id=getIntent().getStringExtra("images_id");
      String product_name=getIntent().getStringExtra("productname_id");
        System.out.println("description"+getIntent().getStringExtra("desc_id"));
        System.out.println("price"+getIntent().getStringExtra("price_id"));
        System.out.println("renter"+getIntent().getStringExtra("renter_id"));
        System.out.println("number"+getIntent().getStringExtra("number_id"));
        byte [] encodeByte= Base64.decode(image_id,Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);


        imageView.setImageBitmap(bitmap);
        textView.setText(product_name);
        t4.setText("Description :   "+getIntent().getStringExtra("desc_id"));
        t2.setText("Price       :   "+getIntent().getStringExtra("price_id"));
        t1.setText("Renter      :   "+getIntent().getStringExtra("renter_id"));
        t3.setText("Number      :   "+getIntent().getStringExtra("number_id"));
    }
    public void calling(View view)
    {
        String s=getIntent().getStringExtra("number_id");
        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:"+s));
        startActivity(i);

    }
}
