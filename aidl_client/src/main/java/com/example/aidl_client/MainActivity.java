package com.example.aidl_client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.aidldemo.IMyAidlInterface;
import com.example.aidldemo.Person;

import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = "zach";

    private IMyAidlInterface aidlInterface;

    Messenger messengerClientCallback, messengerServer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        bindService();

        messengerClientCallback = new Messenger(messengerHandler);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(view -> {
            try {
                aidlInterface.addPerson(new Person("kevin", 1));
                List<Person> personList = aidlInterface.getPersonList();
                Log.e(TAG, personList.toString());

                aidlInterface.modifyPerson(new Person("Cate", 2));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        });

        Button messengerBtn = findViewById(R.id.button_messenger);
        messengerBtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction("service.messenger.server");
            intent.setPackage("com.example.aidldemo");
            bindService(intent, new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    Log.i(TAG, "messengerService onServiceConnected");
                    messengerServer = new Messenger(iBinder);

                    try {
                        Message msg = Message.obtain();
                        msg.replyTo = messengerClientCallback; // set callback
                        msg.what = 1;

                        Bundle bundle = new Bundle();
                        bundle.putString("zach", "value from client");
                        msg.setData(bundle);
                        messengerServer.send(msg);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onServiceDisconnected(ComponentName componentName) {
                    Log.i(TAG, "messengerService onServiceDisconnected");
                }
            }, BIND_AUTO_CREATE);
        });
    }

    Handler messengerHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 2) {
                Log.i(TAG, "HANDLE MSG: " + msg);
            }
            super.handleMessage(msg);
        }
    };

    private void bindService() {
        Intent intent = new Intent(IMyAidlInterface.class.getName());

        //intent.setComponent(new ComponentName("com.example.aidldemo", "com.example.aidldemo.MyAidlService"));
        intent.setAction("service.aidlserver");
        intent.setPackage("com.example.aidldemo");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);

        Log.e(TAG, "start bindService...");
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e(TAG, "Service onServiceConnected");
            aidlInterface = IMyAidlInterface.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e(TAG, "Service onServiceDisconnected");
            aidlInterface = null;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
