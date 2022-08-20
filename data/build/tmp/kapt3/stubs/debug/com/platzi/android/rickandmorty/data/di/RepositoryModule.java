package com.platzi.android.rickandmorty.data.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/platzi/android/rickandmorty/data/di/RepositoryModule;", "", "()V", "characterRepositoryProvider", "Lcom/platzi/android/rickandmorty/data/CharacterRepository;", "remoteCharacterDataSource", "Lcom/platzi/android/rickandmorty/data/RemoteCharacterDataSource;", "localCharacterDataSource", "Lcom/platzi/android/rickandmorty/data/LocalCharacterDataSource;", "episodeRepositoryProvider", "Lcom/platzi/android/rickandmorty/data/EpisodeRepository;", "remoteEpisodeDataSource", "Lcom/platzi/android/rickandmorty/data/RemoteEpisodeDataSource;", "data_debug"})
@dagger.Module()
public final class RepositoryModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.data.CharacterRepository characterRepositoryProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.RemoteCharacterDataSource remoteCharacterDataSource, @org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.LocalCharacterDataSource localCharacterDataSource) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.data.EpisodeRepository episodeRepositoryProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.RemoteEpisodeDataSource remoteEpisodeDataSource) {
        return null;
    }
    
    public RepositoryModule() {
        super();
    }
}