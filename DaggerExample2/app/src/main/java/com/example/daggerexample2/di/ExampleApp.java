package com.example.daggerexample2.di;

import android.app.Application;

public class ExampleApp extends Application {
    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

      applicationComponent = DaggerAppComponent.create();
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }
}
