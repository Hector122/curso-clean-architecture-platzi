package com.example.dagerexample1;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    private RemoteRepo remoteRepo;
    private LocalRepo localRepo;


    @Inject
    UserRepository(RemoteRepo remoteRepo, LocalRepo localRepo){
        this.remoteRepo = remoteRepo;
        this.localRepo = localRepo;
    }

}
