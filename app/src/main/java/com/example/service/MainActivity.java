package com.example.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String ACTION="com.jay.example.service.TEST_SERVICE1";
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent();
        intent.setAction(ACTION);
        intent.setPackage("com.example.service"); //指定启动的是那个应用（lq.cn.twoapp）中的
        Button mStart=(Button)findViewById(R.id.start);
        Button mStop=(Button)findViewById(R.id.stop);

        mStart.setOnClickListener(this);
        mStop.setOnClickListener(this);


    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start:
                startService(intent);
                break;
            case R.id.stop:
                stopService(intent);
                break;
        }
    }
}
