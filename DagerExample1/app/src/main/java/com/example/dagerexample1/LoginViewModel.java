package com.example.dagerexample1;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class LoginViewModel extends ViewModel {
    private final UserRepository userRepository;

    @Inject // tells dagger how to create a instance of UserRepository.
    LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
