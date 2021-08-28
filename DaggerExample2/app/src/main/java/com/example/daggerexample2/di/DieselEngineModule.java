package com.example.daggerexample2.di;

import com.example.daggerexample2.car.DieselEngine;
import com.example.daggerexample2.car.Engine;

import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {
    private final int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    public Engine provideDieselEngine() {
        return new DieselEngine(this.horsePower);
    }

//    @Binds
//    public abstract Engine bindsDieselEngine(DieselEngine engine);
}
