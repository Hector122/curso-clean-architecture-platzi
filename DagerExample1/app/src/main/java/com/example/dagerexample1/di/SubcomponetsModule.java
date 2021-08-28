package com.example.dagerexample1.di;

import dagger.Module;


//the "subcomponents" attribute tells Dagger that this is a subcomponent of the Component this
// module is include in.
@Module(subcomponents = LoginComponent.class)
public class SubcomponetsModule {
}
