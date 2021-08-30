package com.example.daggerexample2.di;

import com.example.daggerexample2.MainActivity;
import com.example.daggerexample2.car.PetrolEngine;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Subcomponent;


@PerActivity
@Subcomponent(modules = {
        WheelsModule.class,
        PetrolEngineModule.class
})
public interface ActivityComponent {
    //Car getCar();

    void inject(MainActivity mainActivity);

    /* After Dagger2 version 2.22 with Factory */
    @Subcomponent.Factory
    interface Factory {

        ActivityComponent factory(@BindsInstance @Named("Horse Power") int horsePower,
                                  @BindsInstance @Named("Engine Capacity") int engineCapacity);
    }

    /* Before Dagger 2.22 with Builder */

//    @Subcomponent.Builder
//    interface Builder {
//
//        @BindsInstance
//        Builder horsePower(@Named("Horse Power") int horsePower);
//
//        @BindsInstance
//        Builder engineCapacity(@Named("Engine Capacity") int engineCapacity);
//
//        // This method is generated automatic is we don't user a builder component
//        // by the 'dependencies' value in component annotation.
//        // that is way we need to specified.
//        ///Builder appComponent(AppComponent appComponent);
//
//        ActivityComponent build();
//    }
}
