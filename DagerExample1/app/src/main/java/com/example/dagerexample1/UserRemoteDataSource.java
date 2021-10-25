package com.example.dagerexample1;

import javax.inject.Inject;

public class UserRemoteDataSource {

    LoginRetrofitService loginRetrofitService;

    @Inject
    UserRemoteDataSource(LoginRetrofitService loginRetrofitService){
        this.loginRetrofitService = loginRetrofitService;
    }
}
