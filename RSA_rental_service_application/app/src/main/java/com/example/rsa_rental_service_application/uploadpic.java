package com.example.rsa_rental_service_application;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.hardware.camera2.CaptureRequest;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class uploadpic extends AppCompatActivity {
private ImageView imageview;
EditText e1,e2,e3,e4;
String username;
String lattitude="error";
String longitude="error";
    Bitmap imageBitmap;
    private  static  final int REQUEST_IMAGE_CAPTURE=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadpic);
        imageview=findViewById(R.id.imageView);
        e1=findViewById(R.id.editText3);
        e2=findViewById(R.id.editText6);
        e3=findViewById(R.id.editText5);
        e4=findViewById(R.id.editText4);
        Intent intent =getIntent();
       username=intent.getStringExtra("username");
       lattitude=intent.getStringExtra("lattitude");
       longitude=intent.getStringExtra("longitude");

    }
    public void TakePicture(View view)
    {
        Intent imageIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(imageIntent.resolveActivity(getPackageManager())!=null)
        {
          startActivityForResult(imageIntent,REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_IMAGE_CAPTURE &&resultCode==RESULT_OK)
        {Bundle extras=data.getExtras();

        imageBitmap=(Bitmap) extras.get("data");
        imageview.setImageBitmap(imageBitmap);}
    }

    public void Exit(View view) throws JSONException {
finish();
    }
    public void uploadDetails(View view) throws Exception {

        System.out.println("******************************************before seending dout mssg 1st");
        String productname=e1.getText().toString();
        String price=e2.getText().toString();
        String productdesc=e3.getText().toString();
        String number=e4.getText().toString();
        ByteArrayOutputStream basc=new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG,100,basc);
        byte[] b=basc.toByteArray();
        String  encodeImage= Base64.encodeToString(b,Base64.DEFAULT);


        System.out.println("***********************before seending dout mssg 2nd");
        JSONObject details=new JSONObject();
        details.put("code","200");
        details.put("username",username);
        details.put("productname",productname);
        details.put("price",price);
        details.put("productdesc",productdesc);
        details.put("number",number);
        details.put("imagedes",encodeImage);
        details.put("lattitude",lattitude);
        details.put("longitude",longitude);


        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);
            System.out.println("************************before seending dout mssg");
            Backend_network.dout.writeUTF(details.toString());
            String s=Backend_network.din.readUTF();
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();

        }
        catch (Exception e) {

            System.out.println("babu  tumse na ho  pawega"+e.getMessage()+"  "+e.getLocalizedMessage()+"  "+ Arrays.toString(e.getStackTrace()));

        }
//        Intent i=new Intent(this,testing.class);
//        i.putExtra("bitmap",encodeImage);
//        startActivity(i);

    }
}
