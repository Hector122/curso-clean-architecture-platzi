package com.example.daggerexample2.di;

import com.example.daggerexample2.car.Driver;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {

    Driver getDriver();
}
