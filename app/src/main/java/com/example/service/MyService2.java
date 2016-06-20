package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * 耗时操作  IntentService
 */
public class MyService2 extends Service {
    //定义onBinder方法所返回的对象
    private MyBinder binder = new MyBinder();

    public static class MyBinder extends Binder
    {
        public void play()
        {
            Log.i("测试", "play()方法被调用!");
        }
    }

    //必须实现的方法,绑定改Service时回调该方法
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("测试", "onBind方法被调用!");
        return binder;
    }

    //Service被创建时回调
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("测试", "onCreate方法被调用!");
        //创建一个线程动态地修改count的值
    }

    //Service断开连接时回调
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("测试", "onUnbind方法被调用!");
        return true;
    }

    //Service被关闭前回调
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("测试", "onDestroyed方法被调用!");
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i("测试", "onRebind方法被调用!");
        super.onRebind(intent);
    }
}
