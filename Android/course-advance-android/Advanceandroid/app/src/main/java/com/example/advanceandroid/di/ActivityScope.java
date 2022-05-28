package com.example.advanceandroid.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope //tell the dagger compiler that this annotation is a scope.
@Retention(RetentionPolicy.RUNTIME) //Tell retained by the VM at run time, so they may be read reflectively.
public @interface ActivityScope {

}