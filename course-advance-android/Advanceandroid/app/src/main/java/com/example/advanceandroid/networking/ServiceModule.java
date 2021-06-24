package com.example.advanceandroid.networking;

import com.example.advanceandroid.model.AdapterFactory;
import com.example.advanceandroid.model.ZonedDateTimeAdapter;
import com.squareup.moshi.Moshi;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

//informs Dagger that this class is a Dagger Module
// One way to include dependencies is include a module inside another one.
@Module(includes = NetworkModule.class)
public abstract class ServiceModule {

    // the include module is because only this class is  going to use this dependency

    // @Provides tell Dagger how to create instances of the type that this function
    // returns (i.e. Moshi).
    // Function parameters are the dependencies of this type.

    @Provides
    @Singleton
    static Moshi provideMoshi() {
        return new Moshi.Builder()
                .add(AdapterFactory.create())
                .add(new ZonedDateTimeAdapter())
                .build();
    }


    @Provides
    @Singleton

    static Retrofit provideRetrofit(Moshi moshi, Call.Factory callFactory, @Named("base_url") String baseUrl) {
        return new Retrofit.Builder()
                .callFactory(callFactory)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }
}
