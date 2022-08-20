package com.platzi.android.rickandmorty.databasemanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\bH\u0007J\u001c\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/platzi/android/rickandmorty/databasemanager/ListStringConverters;", "", "()V", "gson", "Lcom/google/gson/Gson;", "stringListToString", "", "someObjects", "", "stringToStringList", "data", "databasemanager_debug"})
public final class ListStringConverters {
    private final com.google.gson.Gson gson = null;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.util.List<java.lang.String> stringToStringList(@org.jetbrains.annotations.Nullable()
    java.lang.String data) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.lang.String stringListToString(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> someObjects) {
        return null;
    }
    
    public ListStringConverters() {
        super();
    }
}