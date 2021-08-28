package com.example.dagerexample1.di;

import android.app.Application;

public class MyApplication extends Application {
     public ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerApplicationComponent.create();

    }
}
