package com.example.daggerexample2.di;

import com.example.daggerexample2.MainActivity;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;


@PerActivity
@Component(dependencies = AppComponent.class,
        modules = {
                WheelsModule.class,
                PetrolEngineModule.class
        })
public interface ActivityComponent {
    //Car getCar();

    void inject(MainActivity mainActivity);


    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder horsePower(@Named("Horse Power") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("Engine Capacity") int engineCapacity);

        // This method is generated automatic is we don't user a builder component
        // by the 'dependencies' value in component annotation.
        // that is way we need to specified.
        Builder appComponent(AppComponent appComponent);

        ActivityComponent build();
    }
}
