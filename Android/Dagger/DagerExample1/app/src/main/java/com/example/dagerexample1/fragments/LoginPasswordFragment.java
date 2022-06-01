package com.example.dagerexample1.fragments;

;

import android.app.Fragment;
import android.content.Context;

import com.example.dagerexample1.LoginActivity;
import com.example.dagerexample1.LoginViewModel;
import com.example.dagerexample1.di.ActivityScope;

import javax.inject.Inject;

@ActivityScope
public class LoginPasswordFragment extends Fragment {
    @Inject
    LoginViewModel loginViewModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ((LoginActivity) getActivity()).loginComponent.inject(this);
    }
}
