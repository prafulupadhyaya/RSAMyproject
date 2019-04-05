package com.example.rsa_rental_service_application;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

public class UserLoggeddIn extends AppCompatActivity {
TextView e1;String username;

    private static final int REQUEST_LOCATION=1;
    TextView e2,e3;
    LocationManager locationManager;
    String longitude,lattitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_loggedd_in);
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        e2=findViewById(R.id.textView21);
        e3=findViewById(R.id.textView23);

        e1=findViewById(R.id.textView12);
        Intent intent=getIntent();
        username=intent.getStringExtra("username");
        e1.setText(username);

    }
    public void getLocation(View view)
    {
        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            System.out.println("no gps==================");
        }
        else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            getLocationNow();
        }

    }
    public void getLocationNow()
    {
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }
        else
        {
            Location location=locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            System.out.println("hey broda 0");
            if(location!=null)
            {
                double latti=location.getLatitude();
                double longi=location.getLongitude();
                System.out.println("hey broda 1");
                lattitude=String.valueOf(latti);
                longitude=String.valueOf(longi);
                System.out.println("hey broda 2");
                e2.setText("lattitude"+lattitude);
                e3.setText("longtude is"+longitude);
                System.out.println("hey broda 3");
            }
            else
            {
                Toast.makeText(this,"soory unable to track",Toast.LENGTH_LONG).show();
            }

        }


    }
    public void addinfo(View view)
    {
        Intent  intent=new Intent(this,uploadpic.class);
        intent.putExtra("username",username);
        intent.putExtra("lattitude",lattitude);
        intent.putExtra("longitude",longitude);
        startActivity(intent);
    }

    public void explore(View view)
    {

        Intent  intent=new Intent(this,Explore.class);
        intent.putExtra("username",username);
        intent.putExtra("lattitude",lattitude);
        intent.putExtra("longitude",longitude);

        startActivity(intent);
    }
    public void profileuser(View view)
    {
        Intent  intent=new Intent(this,profile.class);
        intent.putExtra("username",username);

        startActivity(intent);
    }
}
