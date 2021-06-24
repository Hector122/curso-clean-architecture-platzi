package com.example.advanceandroid.di;

import android.app.Activity;
import android.content.Context;

import com.example.advanceandroid.base.BaseActivity;
import com.example.advanceandroid.base.MyApplication;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

public class ActivityInjector {
    private final Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors;
    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();


    @Inject // @Inject lets Dagger know how to create instances of this object
    public ActivityInjector(Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors) {
        this.activityInjectors = activityInjectors;
    }

    void inject(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }

        String instancedId = ((BaseActivity) activity).getInstanceId();
        //
        if (cache.containsValue(instancedId)) {
            //noinspection unchecked
            ((AndroidInjector<Activity>) cache.get(instancedId)).inject(activity);
            return;
        }

        //noinspection unchecked
        AndroidInjector.Factory<Activity> injectorFactory =
                (AndroidInjector.Factory<Activity>) activityInjectors.get(activity.getClass()).get();
        AndroidInjector<Activity> androidInjector = injectorFactory.create(activity);
        cache.put(instancedId, androidInjector);
        androidInjector.inject(activity);
    }

    void clear(Activity activity){
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extend BaseActivity");
        }

        cache.remove(((BaseActivity) activity).getInstanceId());
    }

    static ActivityInjector get(Context context){
        return ((MyApplication) context.getApplicationContext()).getActivityInjector();
    }

}
