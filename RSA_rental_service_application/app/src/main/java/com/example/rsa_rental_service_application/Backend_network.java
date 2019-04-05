package com.example.rsa_rental_service_application;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static android.widget.Toast.LENGTH_LONG;

public class Backend_network extends AsyncTask<Void,Void,Void> {//yha b <String,Void,Void>
    static  Socket socket;
    static DataInputStream din;
    static DataOutputStream dout;
    static String k;

    @Override
    protected Void doInBackground(Void... voids) { //yha String aega vrna
        //String mssg=voids[0];
        try {k="hello";
            socket = new Socket("192.168.43.132",5007);
            din=new DataInputStream(socket.getInputStream());
            dout=new DataOutputStream(socket.getOutputStream());
            //dout.writeUTF("i m ready");
            //socket = new Socket("192.168.43.132",5007);
            System.out.println("socket bn gya ");
            //din=new DataInputStream(socket.getInputStream());
            //System.out.println(din.readUTF());

          //  dout=new DataOutputStream(socket.getOutputStream());
            //dout.writeUTF(mssg);



//           din.close();
//            dout.close();
//            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
