package com.example.di;

import com.example.AuthActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract AuthActivity contributeAuthActivity();

    @Provides
    static String someString(){
        return "Runnin test skfl;sa;fl;saflsadkfklsdajfksakfjkls;fsfsafhsaf";
    }


}
