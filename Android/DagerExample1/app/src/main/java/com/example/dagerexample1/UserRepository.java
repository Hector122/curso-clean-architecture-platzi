package com.example.dagerexample1;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    private UserRemoteDataSource userRemoteDataSource;
    private UserLocalDataSource userLocalDataSource;

    @Inject
    UserRepository(UserRemoteDataSource userRemoteDataSource, UserLocalDataSource userLocalDataSource) {
        this.userRemoteDataSource = userRemoteDataSource;
        this.userLocalDataSource = userLocalDataSource;
    }

}
