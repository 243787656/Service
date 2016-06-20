package com.example.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * bind启动方式
 */
public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{
    public static final String ACTION="com.jay.example.service.TEST_SERVICE2";
    Intent intent;
    MyService2.MyBinder binder;
    ServiceConnection serviceConnection=new ServiceConnection() {
        //服务连接成功
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder=( MyService2.MyBinder)service;
        }
        //服务连接失败
        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
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
                //启动服务连接
                bindService(intent,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.stop:
                //解除service绑定
                binder.play();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(serviceConnection);//注销服务连接
    }
}
