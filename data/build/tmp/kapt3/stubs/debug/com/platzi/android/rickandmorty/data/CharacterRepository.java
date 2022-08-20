package com.platzi.android.rickandmorty.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000eJ\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\fJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/platzi/android/rickandmorty/data/CharacterRepository;", "", "remoteCharacterDataSource", "Lcom/platzi/android/rickandmorty/data/RemoteCharacterDataSource;", "localCharacterDataSource", "Lcom/platzi/android/rickandmorty/data/LocalCharacterDataSource;", "(Lcom/platzi/android/rickandmorty/data/RemoteCharacterDataSource;Lcom/platzi/android/rickandmorty/data/LocalCharacterDataSource;)V", "getAllCharacters", "Lio/reactivex/Single;", "", "Lcom/platzi/android/rickandmorty/domain/Character;", "page", "", "getAllFavoriteCharacters", "Lio/reactivex/Flowable;", "getFavoriteCharacterStatus", "Lio/reactivex/Maybe;", "", "characterId", "updateFavoriteCharacterStatus", "character", "data_debug"})
public final class CharacterRepository {
    private final com.platzi.android.rickandmorty.data.RemoteCharacterDataSource remoteCharacterDataSource = null;
    private final com.platzi.android.rickandmorty.data.LocalCharacterDataSource localCharacterDataSource = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<java.util.List<com.platzi.android.rickandmorty.domain.Character>> getAllCharacters(int page) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Flowable<java.util.List<com.platzi.android.rickandmorty.domain.Character>> getAllFavoriteCharacters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Maybe<java.lang.Boolean> getFavoriteCharacterStatus(int characterId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Maybe<java.lang.Boolean> updateFavoriteCharacterStatus(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.domain.Character character) {
        return null;
    }
    
    public CharacterRepository(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.RemoteCharacterDataSource remoteCharacterDataSource, @org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.LocalCharacterDataSource localCharacterDataSource) {
        super();
    }
}