package com.platzi.android.rickandmorty.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/platzi/android/rickandmorty/data/LocalCharacterDataSource;", "", "getAllFavoriteCharacters", "Lio/reactivex/Flowable;", "", "Lcom/platzi/android/rickandmorty/domain/Character;", "getFavoriteCharacterStatus", "Lio/reactivex/Maybe;", "", "characterId", "", "updateFavoriteCharacterStatus", "character", "data_debug"})
public abstract interface LocalCharacterDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Flowable<java.util.List<com.platzi.android.rickandmorty.domain.Character>> getAllFavoriteCharacters();
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Maybe<java.lang.Boolean> getFavoriteCharacterStatus(int characterId);
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Maybe<java.lang.Boolean> updateFavoriteCharacterStatus(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.domain.Character character);
}