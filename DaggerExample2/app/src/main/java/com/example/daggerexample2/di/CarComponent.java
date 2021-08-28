package com.example.daggerexample2.di;

import com.example.daggerexample2.MainActivity;
import com.example.daggerexample2.car.DieselEngine;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
@Singleton
@Component(modules = {
        WheelsModule.class,
        PetrolEngineModule.class
})
public interface CarComponent {
    //Car getCar();

    void inject(MainActivity mainActivity);


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("Horse Power") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("Engine Capacity")int engineCapacity);

        CarComponent build();

    }

}
