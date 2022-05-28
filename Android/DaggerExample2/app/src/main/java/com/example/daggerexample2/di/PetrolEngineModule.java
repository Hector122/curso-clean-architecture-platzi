package com.example.daggerexample2.di;

import com.example.daggerexample2.car.Engine;
import com.example.daggerexample2.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine providePetrolEngineModule(PetrolEngine petrolEngine);
}
