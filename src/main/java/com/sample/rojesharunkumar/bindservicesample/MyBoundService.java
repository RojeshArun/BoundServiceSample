package com.sample.rojesharunkumar.bindservicesample;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MyBoundService extends Service {

    IBinder iBinder = new DemoBinder();


    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(MyBoundService.this, "Ibinder called", Toast.LENGTH_SHORT).show();
        return iBinder;

    }

    class DemoBinder extends Binder {

        public MyBoundService getServiceInstance() {
            return MyBoundService.this;
        }

    }


    public void showMessage(String msg){
        Toast.makeText(MyBoundService.this, "Message: "+msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(MyBoundService.this, "Unbind called", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }
}
