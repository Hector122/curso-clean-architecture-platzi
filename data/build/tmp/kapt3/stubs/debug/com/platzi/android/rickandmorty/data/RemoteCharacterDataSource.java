package com.platzi.android.rickandmorty.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/platzi/android/rickandmorty/data/RemoteCharacterDataSource;", "", "getAllCharacters", "Lio/reactivex/Single;", "", "Lcom/platzi/android/rickandmorty/domain/Character;", "page", "", "data_debug"})
public abstract interface RemoteCharacterDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.platzi.android.rickandmorty.domain.Character>> getAllCharacters(int page);
}