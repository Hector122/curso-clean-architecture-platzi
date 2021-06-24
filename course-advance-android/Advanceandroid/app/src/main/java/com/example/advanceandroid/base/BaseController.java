package com.example.advanceandroid.base;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.example.advanceandroid.di.Injector;

public abstract class BaseController extends Controller {

    private boolean isInject = false;

    @Override
    protected void onContextAvailable(@NonNull Context context) {
        //Controller instance are retained again configuration changes. so this method can be called more than one.
        // this make sure we don't waste any time injecting more than once. though technically i won't chang functionality.
        if (!isInject){
            Injector.inject(this);
            isInject = true;
        }


        super.onContextAvailable(context);

    }
}
