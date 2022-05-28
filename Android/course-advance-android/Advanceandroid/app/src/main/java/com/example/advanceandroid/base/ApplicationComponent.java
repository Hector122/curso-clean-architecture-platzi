package com.example.advanceandroid.base;

import com.example.advanceandroid.data.RepoServiceModule;
import com.example.advanceandroid.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { // @Component makes Dagger create a graph of dependencies
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class})
public interface ApplicationComponent {

    void inject(MyApplication myApplication);
}
