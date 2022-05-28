package com.example.dagerexample1;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.dagerexample1.di.ApplicationComponent;
import com.example.dagerexample1.di.LoginComponent;
import com.example.dagerexample1.di.MyApplication;

import javax.inject.Inject;

public class LoginActivity extends Activity {
    // Reference to the Login graph

    public LoginComponent loginComponent;

    // Fields that need to be injected by the login graph
    // You want Dagger to provide an instance of LoginViewModel from the graph
    @Inject
    LoginViewModel loginViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // make Dagger isntance with @inject fields
        // ((MyApplication) getApplicationContext()).appComponent.inject(this);

        // Creation of the login graph using the application graph
        loginComponent = ((MyApplication) getApplicationContext()).appComponent
                .loginComponent().create();

        // Make Dagger instantiate @Inject fields in LoginActivity
        loginComponent.inject(this);

        //now LoginViewModel is Avariable.

        super.onCreate(savedInstanceState);
    }
}
