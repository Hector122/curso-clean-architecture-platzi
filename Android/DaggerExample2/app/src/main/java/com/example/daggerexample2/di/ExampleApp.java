package com.example.daggerexample2.di;

import android.app.Application;

public class ExampleApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.factory()
              .create(new DriverModule("Hans Solo"));
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
