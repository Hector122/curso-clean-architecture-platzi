package com.example.advanceandroid.trending;

import com.example.advanceandroid.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface TrendingReposComponent extends AndroidInjector<TrendingRepoController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingRepoController>{

    }
}
