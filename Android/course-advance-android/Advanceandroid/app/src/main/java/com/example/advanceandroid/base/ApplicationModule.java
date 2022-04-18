package com.example.advanceandroid.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module  // This annotation tell dagger that this class is a provider of dependencies.
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides // This annotation tell dagger that this method is PROVIDED a dependency.
    Context provideApplicationContext(){
        return application;
    }
}
