package com.platzi.android.rickandmorty.databasemanager.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/platzi/android/rickandmorty/databasemanager/di/DatabaseModule;", "", "()V", "databaseProvider", "Lcom/platzi/android/rickandmorty/databasemanager/CharacterDatabase;", "app", "Landroid/app/Application;", "localCharacterDataSourceProvider", "Lcom/platzi/android/rickandmorty/data/LocalCharacterDataSource;", "database", "databasemanager_debug"})
@dagger.Module()
public final class DatabaseModule {
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.databasemanager.CharacterDatabase databaseProvider(@org.jetbrains.annotations.NotNull()
    android.app.Application app) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.data.LocalCharacterDataSource localCharacterDataSourceProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.databasemanager.CharacterDatabase database) {
        return null;
    }
    
    public DatabaseModule() {
        super();
    }
}