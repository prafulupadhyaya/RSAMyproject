package com.example.rsa_rental_service_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class profile extends AppCompatActivity {
String username;
TextView textView;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        textView=findViewById(R.id.textView16);
        Intent intent =getIntent();
        username=intent.getStringExtra("username");
        textView.setText(username);
    }
}
