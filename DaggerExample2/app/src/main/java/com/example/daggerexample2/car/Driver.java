package com.example.daggerexample2.car;

public class Driver {
    // For example propose imaging we don't own this class anymore
    // so we can use constructors injection.

    String name;

    public Driver(String name) {
        this.name = name;
    }
}
