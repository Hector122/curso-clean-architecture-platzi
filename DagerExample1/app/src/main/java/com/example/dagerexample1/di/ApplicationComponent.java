package com.example.dagerexample1.di;


import com.example.dagerexample1.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
// The "modules" attribute in the @Component annotation tells Dagger what Modules
// to include when building the graph
@Component(modules = {NetworkModule.class, SubcomponetsModule.class})
public interface ApplicationComponent {

    //Tells dagger that loginActivity wants injection.
    // this responsabilities now pass to Subcomppnets Module.
   void inject(LoginActivity loginActivity);


    // This function exposes the LoginComponent Factory out of the graph so consumers
// can use it to obtain new instances of LoginComponent
    LoginComponent.Factory loginComponent();
}
