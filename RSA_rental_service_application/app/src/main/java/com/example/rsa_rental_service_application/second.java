package com.example.rsa_rental_service_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class second extends AppCompatActivity {
    static BufferedReader input;
    static PrintWriter output;
    static Socket socket=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        networking net=new networking();

    }

    public void signup(View view)
    {

//        try {
//
//            socket = new Socket("127.0.0.1", 5006);
//            Toast.makeText(this,"hi theere",Toast.LENGTH_LONG) .show();
//            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            output = new PrintWriter(socket.getOutputStream(), true);
//
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            //Toast.makeText(this,"sorre",Toast.LENGTH_LONG) .show();
//
//        }
        Intent intent=new Intent(this,signup.class);
        startActivity(intent);
        finish();

    }
    public void signin(View view)
    {
        Intent intent= new Intent(this,signin.class);
        startActivity(intent);
        finish();
    }
}
