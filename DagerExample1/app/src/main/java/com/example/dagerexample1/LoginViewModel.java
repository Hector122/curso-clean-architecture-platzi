package com.example.dagerexample1;

import androidx.lifecycle.ViewModel;

import com.example.dagerexample1.di.ActivityScope;

import javax.inject.Inject;


// A unique instance of LoginViewModel is provided in Components
// annotated with @ActivityScope
@ActivityScope
public class LoginViewModel extends ViewModel {
    private final UserRepository userRepository;

    @Inject // tells dagger how to create a instance of UserRepository.
    LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
