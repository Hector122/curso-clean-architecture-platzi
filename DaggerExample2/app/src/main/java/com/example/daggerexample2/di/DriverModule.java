package com.example.daggerexample2.di;

import com.example.daggerexample2.car.Driver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public abstract class DriverModule {

    @Provides
    @Singleton
    static Driver provideDriver(){
        return new Driver();
    }
}
