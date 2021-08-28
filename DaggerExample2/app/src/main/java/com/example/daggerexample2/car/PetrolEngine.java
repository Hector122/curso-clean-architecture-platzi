package com.example.daggerexample2.car;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class PetrolEngine implements Engine {
    private static final String TAG = "PetrolEngine";
    private final int horsePower;
    private final int engineCapacity;

    @Inject
    public PetrolEngine(@Named("Horse Power") int horsePower,@Named("Engine Capacity") int engineCapacity) {
        this.horsePower = horsePower;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void start() {
        Log.i(TAG, "Petrol engine started." + "\n Horse power: " + horsePower
                + "\n Engine Capacity: " + engineCapacity);
    }
}
