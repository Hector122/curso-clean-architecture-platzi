package com.example.daggerexample2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daggerexample2.car.Car;
import com.example.daggerexample2.di.ActivityComponent;
import com.example.daggerexample2.di.DaggerAppComponent;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {
    @Inject
    Car car1, car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ActivityComponent activityComponent = DaggerAppComponent.create()
                .provideActivityComponent(new DieselEngineModule(100)); */

        ActivityComponent activityComponent = DaggerAppComponent.create()
                .getActivityComponentFactory()
                .factory(250, 1400);

        activityComponent.inject(this);

        car1.engine.start();
        car1.driving();

        car2.engine.start();
        car2.driving();
    }
}