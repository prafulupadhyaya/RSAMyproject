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

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class signin extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        e2=findViewById(R.id.editText2);
        e1=findViewById(R.id.editText);

    }
    public void send(View view) throws IOException {

        JSONObject signin=new JSONObject();
        try {
            signin.put("code","504");
            signin.put("username",e1.getText().toString());
            signin.put("password",e2.getText().toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }


        //Backend_network back=new Backend_network();
        //back.execute(e1.getText().toString());
        System.out.println("in the send fn");
        System.out.println(Backend_network.k);
        try {StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

            Backend_network.dout.writeUTF(signin.toString());


        } catch (Exception e) {
            System.out.println("babu  tumse na ho  pawega"+e.getMessage()+"  "+e.getLocalizedMessage()+"  "+ Arrays.toString(e.getStackTrace()));

        }
        if(Backend_network.din.readUTF().equals("successful"))
        {

            Intent intent=new Intent(this,UserLoggeddIn.class);
            intent.putExtra("username",e1.getText().toString());
            startActivity(intent);
            finish();


        }
        else
        {
            Toast.makeText(getApplicationContext(),"unsuccessful",Toast.LENGTH_LONG).show();
        }



    }
}
