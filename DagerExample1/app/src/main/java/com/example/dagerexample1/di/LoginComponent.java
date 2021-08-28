package com.example.dagerexample1.di;

import com.example.dagerexample1.LoginActivity;

import dagger.Subcomponent;

@Subcomponent
public interface LoginComponent {

    @Subcomponent.Factory
    interface Factory {
        LoginComponent create();
    }


    // This tells Dagger that LoginActivity requests injection from LoginComponent
    // so that this subcomponent graph needs to satisfy all the dependencies of the
    // fields that LoginActivity is injecting
    void inject(LoginActivity loginActivity);
}
