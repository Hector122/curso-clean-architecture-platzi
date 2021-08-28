package com.example.daggerexample2.external;

import android.util.Log;

/***
 *    For example propose imaging we don't own this class
 *    so we can use constructors injection.
 */
public class Tires {
    public static final String TAG = "Tires";


    public void inflate() {
        Log.i(TAG, "Inflated tires");
    }
}
