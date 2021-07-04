package com.example.advanceandroid.di;

import android.app.Activity;
import android.content.Context;

import com.bluelinelabs.conductor.Controller;
import com.example.advanceandroid.base.BaseActivity;
import com.example.advanceandroid.base.BaseController;
import com.example.advanceandroid.base.MyApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;

@ActivityScope
public class ScreenInjector {
    // is a component inject this more than one use the already created.
    private final Map<Class<? extends  Controller>, Provider<AndroidInjector.Factory<? extends  Controller>>> screenInjectors;
    private final Map<String, AndroidInjector<Controller>>  cache = new HashMap<>();

    @Inject
    public ScreenInjector(Map<Class<? extends Controller>, Provider<AndroidInjector.Factory<? extends Controller>>> screenInjectors) {
        this.screenInjectors = screenInjectors;
    }

    void inject(Controller controller){
        if(!(controller instanceof BaseController)){
            throw new IllegalArgumentException("Controller must extends BaseController");
        }

        String instanceId = controller.getInstanceId();
        if(cache.containsKey(instanceId)){
            cache.get(instanceId).inject(controller);
            return;
        }

        //noinspection unchecked
        AndroidInjector.Factory<Controller> injectorFactory  = (AndroidInjector.Factory<Controller>) screenInjectors.get(controller.getClass()).get();
        AndroidInjector<Controller> injector = injectorFactory.create(controller);
        cache.put(instanceId, injector);
        injector.inject(controller);
    }

    void clear(Controller controller){
        cache.remove(controller.getInstanceId());
    }

    static ScreenInjector get(Activity activity){
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Controller must be hosted by BasActivity");
        }

        return ((BaseActivity) activity ).getScreenInjector();
    }
}
