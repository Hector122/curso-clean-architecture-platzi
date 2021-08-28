package com.example.daggerexample2.car;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {
    private static final String TAG = "DieselEngine";

    private final int horsePower;

//    @Inject
//    public DieselEngine() {
//
//    }

    // this is inserting at runtime.
    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.i(TAG, "Diesel engine started. Horse power: " + horsePower );
    }
}
