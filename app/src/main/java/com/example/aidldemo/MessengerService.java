package com.example.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by zhen.liu on 19/11/23
 */
public class MessengerService extends Service {
    private static final String TAG = "zach";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }


    Handler messengerHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == 1) {
                Log.i(TAG, "server handle msg: " + msg + ", key: " + msg.getData().getString("bundleKey"));

                Messenger clientCallback = msg.replyTo;
                Message toClient = Message.obtain();
                toClient.what = 2;

                try {
                    clientCallback.send(toClient);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
            super.handleMessage(msg);
        }
    };

    private Messenger messenger = new Messenger(messengerHandler);

}
