package com.example.dagerexample1.di;

import com.example.dagerexample1.LoginRetrofitService;
import com.example.dagerexample1.LoginService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

// @Module informs Dagger that this class is a Dagger Module

@Module
public class NetworkModule {

    @Provides
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    // @Provides tell Dagger how to create instances of the type that this function
    //    returns (i.e. LoginRetrofitService).
    //     Function parameters are the dependencies of this type.
    @Provides
    @Singleton
    public LoginRetrofitService provideLoginRetrofitServices(OkHttpClient okHttpClient) {
        // Whenever Dagger needs to provide an instance of type LoginRetrofitService,
        // this code (the one inside the @Provides method) is run.
        return new Retrofit.Builder()
                .baseUrl("https://example.com")
                .build()
                .create(LoginService.class);
    }
}
