package com.example.daggerexample2.external;

import com.example.daggerexample2.external.Rim;
import com.example.daggerexample2.external.Tires;

import javax.inject.Inject;

public class Wheels {
    // For example propose imaging we don't own this class
    // so we can use constructors injection.
    private Rim rim;
    private Tires tires;

    public Wheels(Rim rim, Tires tires) {
        this.rim = rim;
        this.tires = tires;
    }
}
