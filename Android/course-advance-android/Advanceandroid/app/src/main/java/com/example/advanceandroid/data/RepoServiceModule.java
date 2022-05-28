package com.example.advanceandroid.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class RepoServiceModule {

    @Provides //tell Dagger how to create instances of the type that this function
    @Singleton
    static RepoService provideRepoService(Retrofit retrofit){
        return retrofit.create(RepoService.class);
    }
}
