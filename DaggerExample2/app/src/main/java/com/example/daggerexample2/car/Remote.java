package com.example.daggerexample2.car;

import android.util.Log;

import javax.inject.Inject;

public class Remote {
    public static final String TAG = "Remote";

    @Inject
    public Remote() {
    }

    public void setListeners(Car car){
        Log.i(TAG,"remote  connected" );
    }
}
