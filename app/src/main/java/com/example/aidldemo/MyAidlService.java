package com.example.aidldemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAidlService extends Service {
    private static final String TAG = "zach";
    private List<Person> persons;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //persons = new ArrayList<>();
        //Log.e(TAG, "onBind succ");

        return iBinder;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    private IBinder iBinder = new IMyAidlInterface.Stub() {
        @Override
        public void addPerson(Person person) throws RemoteException {
            persons.add(person);
        }

        @Override
        public String modifyPerson(Person person) throws RemoteException {
            return "";
        }

        @Override
        public String getPersonInfo(Person info) throws RemoteException {
            return "";
        }

        @Override
        public void convertPeople(Person people) throws RemoteException {

        }

        @Override
        public List<Person> getPersonList() throws RemoteException {
            return persons;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "MyAidlService onCreate");

    }
}
