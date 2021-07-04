package com.example.advanceandroid.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.example.advanceandroid.di.Injector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseController extends Controller {

    //this allow to add multiple disposable to one object.
    private final CompositeDisposable disposable = new CompositeDisposable();

    private boolean isInject = false;
    private Unbinder unbinder;

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

    @NonNull
    @Override
    protected final View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(layoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        disposable.addAll(subscriptions());
        return view;
    }


    @Override
    protected void onDestroyView(@NonNull View view) {
        disposable.clear();

        if(unbinder != null){
            unbinder.unbind();
            unbinder = null;
        }
    }

    protected void onViewBound(View view){

    }

    protected Disposable[] subscriptions(){
        return new Disposable[0];
    }

    @LayoutRes
    protected abstract int layoutRes();
}
