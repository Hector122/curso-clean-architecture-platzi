package com.example.dagerexample1.di;

import com.example.dagerexample1.LoginActivity;
import com.example.dagerexample1.fragments.LoginPasswordFragment;
import com.example.dagerexample1.fragments.LoginUsernameFragment;

import dagger.Subcomponent;

// Classes annotated with @ActivityScope are scoped to the graph and the same
// instance of that type is provided every time the type is requested.
@ActivityScope
//@Subcomponent annotation informs Dagger this interface is a Dagger Subcomponent
@Subcomponent
public interface LoginComponent {

    //Factory that is use to created a instance of this subcomponent.
    @Subcomponent.Factory
    interface Factory{
        LoginComponent create();
    }


    // This tells Dagger that LoginActivity requests injection from LoginComponent
    // so that this subcomponent graph needs to satisfy all the dependencies of the
    // fields that LoginActivity is injecting
    void inject(LoginActivity activity);
    //LoginUsernameFragment and LoginPasswordFragment
    // request injection from LoginComponent. The graph needs to satisfy
    // all the dependencies of the fields those classes are injecting
    void inject(LoginPasswordFragment fragment);
    void inject(LoginUsernameFragment fragment);
}
