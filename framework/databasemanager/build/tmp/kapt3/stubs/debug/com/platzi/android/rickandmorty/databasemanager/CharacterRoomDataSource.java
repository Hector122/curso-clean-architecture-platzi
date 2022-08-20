package com.platzi.android.rickandmorty.databasemanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/platzi/android/rickandmorty/databasemanager/CharacterRoomDataSource;", "Lcom/platzi/android/rickandmorty/data/LocalCharacterDataSource;", "database", "Lcom/platzi/android/rickandmorty/databasemanager/CharacterDatabase;", "(Lcom/platzi/android/rickandmorty/databasemanager/CharacterDatabase;)V", "characterDao", "Lcom/platzi/android/rickandmorty/databasemanager/CharacterDao;", "getCharacterDao", "()Lcom/platzi/android/rickandmorty/databasemanager/CharacterDao;", "characterDao$delegate", "Lkotlin/Lazy;", "getAllFavoriteCharacters", "Lio/reactivex/Flowable;", "", "Lcom/platzi/android/rickandmorty/domain/Character;", "getFavoriteCharacterStatus", "Lio/reactivex/Maybe;", "", "characterId", "", "updateFavoriteCharacterStatus", "character", "databasemanager_debug"})
public final class CharacterRoomDataSource implements com.platzi.android.rickandmorty.data.LocalCharacterDataSource {
    private final kotlin.Lazy characterDao$delegate = null;
    
    private final com.platzi.android.rickandmorty.databasemanager.CharacterDao getCharacterDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Flowable<java.util.List<com.platzi.android.rickandmorty.domain.Character>> getAllFavoriteCharacters() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Maybe<java.lang.Boolean> getFavoriteCharacterStatus(int characterId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Maybe<java.lang.Boolean> updateFavoriteCharacterStatus(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.domain.Character character) {
        return null;
    }
    
    public CharacterRoomDataSource(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.databasemanager.CharacterDatabase database) {
        super();
    }
}