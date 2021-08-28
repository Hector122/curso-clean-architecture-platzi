package com.example.daggerexample2.di;

import com.example.daggerexample2.external.Wheels;
import com.example.daggerexample2.external.Rim;
import com.example.daggerexample2.external.Tires;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class WheelsModule {
    @Provides
   static Rim provideRim(){
        return new Rim();
    }

    @Provides
    static Tires provideTires(){
        Tires tires = new Tires();
        tires.inflate();
        return tires;
    }

    @Provides
    static Wheels provideWheels(Rim rim, Tires tires){
        return  new Wheels(rim, tires);
    }
}
