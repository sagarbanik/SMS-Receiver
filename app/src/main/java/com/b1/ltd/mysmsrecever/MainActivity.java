package com.b1.ltd.mysmsrecever;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MyTag12";
    String[] permissions ={Manifest.permission.RECEIVE_SMS,Manifest.permission.READ_CONTACTS};
    final int PERM_REQ_CODE=10;
    public static TextView tvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage=findViewById(R.id.tvMessage);

        ActivityCompat.requestPermissions(this,permissions,PERM_REQ_CODE);

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,permissions,PERM_REQ_CODE);
        }
    }
}
