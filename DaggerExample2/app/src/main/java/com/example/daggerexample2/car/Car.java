package com.example.daggerexample2.car;

import android.util.Log;

import com.example.daggerexample2.di.PerActivity;
import com.example.daggerexample2.external.Wheels;

import javax.inject.Inject;

@PerActivity
public class Car {
    private static final String TAG = "Car";
    // execution second by dagger
    @Inject
    public Engine engine;

    private Wheels wheels;
    private Driver driver;

    // execution first by dagger
    @Inject
    public Car(/*Engine engine,*/ Wheels wheels, Driver driver) {
        //this.engine = engine;
        this.wheels = wheels;
        this.driver = driver;
    }

    //execution third by dagger
    @Inject
    public void setListeners(Remote remote) {
        remote.setListeners(this);
    }


    public void driving() {
        Log.i(TAG,driver + " drives " + this );
    }
}
