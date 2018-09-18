package com.tinkertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import comtinkertest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "I`m patch! version 1  no internet", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "补丁下载成功", Toast.LENGTH_SHORT).show();
    }
}
