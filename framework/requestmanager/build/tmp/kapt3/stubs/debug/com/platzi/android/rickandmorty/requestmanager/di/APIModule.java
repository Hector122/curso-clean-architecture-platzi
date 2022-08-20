package com.platzi.android.rickandmorty.requestmanager.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0007J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/platzi/android/rickandmorty/requestmanager/di/APIModule;", "", "()V", "baseUrlProvider", "", "characterRequestProvider", "Lcom/platzi/android/rickandmorty/requestmanager/CharacterRequest;", "baseUrl", "episodeRequestProvider", "Lcom/platzi/android/rickandmorty/requestmanager/EpisodeRequest;", "remoteCharacterDataSourceProvider", "Lcom/platzi/android/rickandmorty/data/RemoteCharacterDataSource;", "characterRequest", "remoteEpisodeDataSourceProvider", "Lcom/platzi/android/rickandmorty/data/RemoteEpisodeDataSource;", "episodeRequest", "requestmanager_debug"})
@dagger.Module()
public final class APIModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.requestmanager.CharacterRequest characterRequestProvider(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "baseUrl")
    java.lang.String baseUrl) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "baseUrl")
    @javax.inject.Singleton()
    @dagger.Provides()
    public final java.lang.String baseUrlProvider() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.data.RemoteCharacterDataSource remoteCharacterDataSourceProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.requestmanager.CharacterRequest characterRequest) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.requestmanager.EpisodeRequest episodeRequestProvider(@org.jetbrains.annotations.NotNull()
    @javax.inject.Named(value = "baseUrl")
    java.lang.String baseUrl) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.data.RemoteEpisodeDataSource remoteEpisodeDataSourceProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.requestmanager.EpisodeRequest episodeRequest) {
        return null;
    }
    
    public APIModule() {
        super();
    }
}