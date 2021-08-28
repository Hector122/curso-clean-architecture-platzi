package com.example.daggerexample2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.daggerexample2.car.Car;
import com.example.daggerexample2.di.ActivityComponent;
import com.example.daggerexample2.di.AppComponent;
import com.example.daggerexample2.di.DaggerActivityComponent;
import com.example.daggerexample2.di.ExampleApp;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {
    @Inject
    Car car1, car2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityComponent activityComponent = DaggerActivityComponent.builder()
                .appComponent(((ExampleApp)getApplication()).getApplicationComponent())
                .horsePower(250)
                .engineCapacity(1400)
                .build();

        activityComponent.inject(this);

        car1.engine.start();
        car1.driving();

        car2.engine.start();
        car2.driving();
    }
}