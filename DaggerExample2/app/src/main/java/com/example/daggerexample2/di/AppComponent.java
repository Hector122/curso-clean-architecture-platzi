package com.example.daggerexample2.di;

import com.example.daggerexample2.car.Driver;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {

    //Driver getDriver();

    // We need to pass all modules that are not abstract and don't have a default constructor.
    // ActivityComponent provideActivityComponent(DieselEngineModule dieselEngineModule);


    ActivityComponent.Builder getActivityComponentBuilder(); //PetrolEngineModule

}
