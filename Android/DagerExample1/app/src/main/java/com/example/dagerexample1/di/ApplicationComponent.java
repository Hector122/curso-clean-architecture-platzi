package com.example.dagerexample1.di;


import javax.inject.Singleton;

import dagger.Component;


// The "modules" attribute in the @Component annotation tells Dagger what Modules
// to include when building the graph

// Including SubcomponentsModule, tell ApplicationComponent that
// LoginComponent is its subcomponent.
@Singleton
@Component(modules = {NetworkModule.class, SubcomponentsModule.class})
public interface ApplicationComponent {

    //Tells dagger that loginActivity wants injection.
    // this responsabilities now pass to Subcomppnets Module.
  // void inject(LoginActivity loginActivity);


    // This function exposes the LoginComponent Factory out of the graph so consumers
    // can use it to obtain new instances of LoginComponent
    LoginComponent.Factory loginComponent();
}
