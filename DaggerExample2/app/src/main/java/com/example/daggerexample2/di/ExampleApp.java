package com.example.daggerexample2.di;

import android.app.Application;

public class ExampleApp extends Application {
    private CarComponent carComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        carComponent = DaggerCarComponent.builder()
                .horsePower(250)
                .engineCapacity(1400)
                .build();
    }

    public CarComponent getCarComponent() {
        return carComponent;
    }
}
