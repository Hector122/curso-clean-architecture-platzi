package com.example.dagerexample1.fragments;

import android.app.Fragment;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.dagerexample1.LoginActivity;
import com.example.dagerexample1.LoginViewModel;
import com.example.dagerexample1.di.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class LoginUsernameFragment extends Fragment {

    @Inject
    LoginViewModel loginViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // Obtaining the login graph from LoginActivity and instantiate
        // the @Inject fields with objects from the graph
        ((LoginActivity) getActivity()).loginComponent.inject(this);

        // Now you can access loginViewModel here and onCreateView too
        // (shared instance with the Activity and the other Fragment)
    }
}
