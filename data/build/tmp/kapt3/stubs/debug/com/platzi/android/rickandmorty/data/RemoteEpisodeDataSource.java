package com.platzi.android.rickandmorty.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/platzi/android/rickandmorty/data/RemoteEpisodeDataSource;", "", "getEpisodeFromCharacter", "Lio/reactivex/Single;", "", "Lcom/platzi/android/rickandmorty/domain/Episode;", "episodeUrlList", "", "data_debug"})
public abstract interface RemoteEpisodeDataSource {
    
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<com.platzi.android.rickandmorty.domain.Episode>> getEpisodeFromCharacter(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> episodeUrlList);
}