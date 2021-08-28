package com.example.daggerexample2.external;

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
