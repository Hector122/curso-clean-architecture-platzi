package com.example.advanceandroid.base;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.Router;
import com.example.advanceandroid.R;
import com.example.advanceandroid.di.Injector;
import com.example.advanceandroid.di.ScreenInjector;
import com.example.advanceandroid.ui.DefaultScreenNavigator;

import java.util.UUID;

import javax.inject.Inject;


public abstract class BaseActivity extends AppCompatActivity {
    //key
    private static final String INSTANCE_ID_KEY = "instance_id";

    @Inject
    ScreenInjector screenInjector;

    @Inject
    DefaultScreenNavigator screenNavigator;

    Router router;

    //instance id for configuration changes.
    public String instanceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null){
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            instanceId = UUID.randomUUID().toString();
        }

        Injector.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(layoutRes());

        ViewGroup screenContainer = findViewById(R.id.screen_container);
        if(screenContainer == null){
            throw new NullPointerException("Activity must have a view id: screen_container.");
        }

        router = Conductor.attachRouter(this, screenContainer, savedInstanceState);
        screenNavigator.initWithRouter(router, initController());

        monitorBackStack();
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract Controller initController();

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(INSTANCE_ID_KEY, instanceId);
    }

    @Override
    public void onBackPressed() {
        if(!screenNavigator.pop()){
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        screenNavigator.clear();

        if(isFinishing()){
            Injector.clearComponent(this);
        }
    }

    /**
     * Allow to have one instance id across configuration changes.
     * @return instance ID
     */
    public String getInstanceId() {
        return instanceId;
    }

    public  ScreenInjector getScreenInjector(){
        return screenInjector;
    }

    private void monitorBackStack(){
        router.addChangeListener(new ControllerChangeHandler.ControllerChangeListener() {
            @Override
            public void onChangeStarted(@Nullable Controller to, @Nullable Controller from, boolean isPush,
                                        @NonNull ViewGroup container, @NonNull ControllerChangeHandler handler) {

            }

            @Override
            public void onChangeCompleted(@Nullable Controller to, @Nullable Controller from, boolean isPush,
                                          @NonNull ViewGroup container, @NonNull ControllerChangeHandler handler) {
                // It is a pop controller and form is not null.
                if(!isPush && from != null){
                    //clear
                    Injector.clearComponent(from);
                }
            }
        });
    }
}
