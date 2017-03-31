package com.sample.rojesharunkumar.bindservicesample;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MyBoundService myBoundService;
    boolean isBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void BindService(View view) {

        Intent intent = new Intent( MainActivity.this,MyBoundService.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);

    }



    public void UnBindService(View view) {

        if(isBind){
            unbindService(serviceConnection);
        }

    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinderservice) {

            MyBoundService.DemoBinder demoBinder = (MyBoundService.DemoBinder) iBinderservice;
            myBoundService = demoBinder.getServiceInstance();
            myBoundService.showMessage("Welcome to bound service");
            isBind = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            isBind = false;

        }
    };


}
