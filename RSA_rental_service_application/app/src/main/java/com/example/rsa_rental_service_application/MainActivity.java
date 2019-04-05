package com.example.rsa_rental_service_application;

import android.Manifest;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void secondac(View view)
    {
        Intent intent=new Intent(this,second.class);
        startActivity(intent);
        Backend_network back=new Backend_network();
        back.execute();
        finish();
    }
}
