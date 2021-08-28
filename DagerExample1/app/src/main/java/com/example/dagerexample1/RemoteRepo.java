package com.example.dagerexample1;

import javax.inject.Inject;

public class RemoteRepo {

    LoginRetrofitService loginRetrofitService;

    @Inject
    RemoteRepo(LoginRetrofitService loginRetrofitService){
        this.loginRetrofitService = loginRetrofitService;
    }
}
