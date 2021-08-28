package com.example.dagerexample1;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.dagerexample1.di.ApplicationComponent;
import com.example.dagerexample1.di.MyApplication;

import javax.inject.Inject;

public class LoginActivity extends Activity {
    // You want Dagger to provide an instance of LoginViewModel from the graph
    @Inject
    LoginViewModel loginViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // make Dagger isntance with @inject fields
        ((MyApplication) getApplicationContext()).appComponent.inject(this);

        //now LoginViewModel is Avariable.

        super.onCreate(savedInstanceState);
    }
}
