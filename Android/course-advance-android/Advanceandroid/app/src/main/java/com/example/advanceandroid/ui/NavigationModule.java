package com.example.advanceandroid.ui;

import javax.inject.Scope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigationModule  {

    @Binds
    abstract ScreenNavigator providerScreenNavigation(DefaultScreenNavigator screenNavigator);

}
