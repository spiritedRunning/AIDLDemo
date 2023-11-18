package com.example.aidl_client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.aidldemo.IMyAidlInterface;
import com.example.aidldemo.Person;

import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    private IMyAidlInterface aidlInterface;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            try {
                aidlInterface.addPerson(new Person("123", 1));
                List<Person> personList = aidlInterface.getPersonList();
                Log.e(TAG, personList.toString());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        bindService();
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.example.aidldemo", "com.example.aidldemo.MyAidlService"));
        bindService(intent, connection, Context.BIND_AUTO_CREATE);


    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e(TAG, "Service connected succ");
            aidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e(TAG, "Service connected failed");
            aidlInterface = null;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
