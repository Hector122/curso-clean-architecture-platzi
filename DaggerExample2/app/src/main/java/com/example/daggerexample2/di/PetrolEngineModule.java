package com.example.daggerexample2.di;

import com.example.daggerexample2.car.Engine;
import com.example.daggerexample2.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class PetrolEngineModule {

//    @Provides
//    Engine providePetrolEngine(PetrolEngine engine){
//        return engine;
//    }

    @Binds
    abstract Engine bindsEngine(PetrolEngine engine);

}
