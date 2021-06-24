package com.example.advanceandroid.home;

import com.bluelinelabs.conductor.Controller;
import com.example.advanceandroid.di.ControllerKey;
import com.example.advanceandroid.trending.TrendingRepoController;
import com.example.advanceandroid.trending.TrendingReposComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingReposComponent.class
})
public abstract class MainScreenBidingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingRepoController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);

}
