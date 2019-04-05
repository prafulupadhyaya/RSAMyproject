package com.example.rsa_rental_service_application;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

public class signup extends AppCompatActivity {
    EditText e1,e2,e3,e4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.email);
        e3=findViewById(R.id.mobile);
        e4=findViewById(R.id.password);

    }

    public void create(View view) throws Exception {
        JSONObject signup=new JSONObject();
        String username=e1.getText().toString();
        String email=e2.getText().toString();
        String mobile=e3.getText().toString();
        String password=e4.getText().toString();

        try {
            signup.put("code","400");
            signup.put("username",username);
            signup.put("email",email);
            signup.put("mobile",mobile);
            signup.put("password",password);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

            Backend_network.dout.writeUTF(signup.toString());
        }
        catch (Exception e) {

            System.out.println("babu  tumse na ho  pawega"+e.getMessage()+"  "+e.getLocalizedMessage()+"  "+ Arrays.toString(e.getStackTrace()));

        }
        //Toast.makeText(getApplicationContext(),"check",Toast.LENGTH_LONG);
        if(Backend_network.din.readUTF().equals("successful"))
        {
            Toast.makeText(getApplicationContext(),"successful",Toast.LENGTH_LONG).show();
           Intent intent=new Intent(this,UserLoggeddIn.class);
            intent.putExtra("username",username);
           startActivity(intent);
            finish();


        }
        else
        {
            Toast.makeText(getApplicationContext(),"unsuccessful",Toast.LENGTH_LONG).show();
        }

    }
}
