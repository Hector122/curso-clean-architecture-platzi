package com.example.daggerexample2.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = DriverModule.class)
public interface AppComponent {

    //Driver getDriver();

    // We need to pass all modules that are not abstract and don't have a default constructor.
    // ActivityComponent provideActivityComponent(DieselEngineModule dieselEngineModule);

//with builder before dagger 22.2
    //ActivityComponent.Builder getActivityComponentBuilder(); //PetrolEngineModule

    //after Dagger 2.22
    ActivityComponent.Factory getActivityComponentFactory();

//    @Component.Factory
//    interface Factory {
//        AppComponent create(DriverModule driverModule);
//    }
}
