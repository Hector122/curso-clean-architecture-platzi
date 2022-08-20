package com.platzi.android.rickandmorty.requestmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/platzi/android/rickandmorty/requestmanager/CharacterRetrofitDataSource;", "Lcom/platzi/android/rickandmorty/data/RemoteCharacterDataSource;", "characterRequest", "Lcom/platzi/android/rickandmorty/requestmanager/CharacterRequest;", "(Lcom/platzi/android/rickandmorty/requestmanager/CharacterRequest;)V", "getAllCharacters", "Lio/reactivex/Single;", "", "Lcom/platzi/android/rickandmorty/domain/Character;", "page", "", "requestmanager_debug"})
public final class CharacterRetrofitDataSource implements com.platzi.android.rickandmorty.data.RemoteCharacterDataSource {
    private final com.platzi.android.rickandmorty.requestmanager.CharacterRequest characterRequest = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.platzi.android.rickandmorty.domain.Character>> getAllCharacters(int page) {
        return null;
    }
    
    public CharacterRetrofitDataSource(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.requestmanager.CharacterRequest characterRequest) {
        super();
    }
}