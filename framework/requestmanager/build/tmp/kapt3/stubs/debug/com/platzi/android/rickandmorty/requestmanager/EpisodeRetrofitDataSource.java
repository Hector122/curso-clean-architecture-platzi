package com.platzi.android.rickandmorty.requestmanager;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/platzi/android/rickandmorty/requestmanager/EpisodeRetrofitDataSource;", "Lcom/platzi/android/rickandmorty/data/RemoteEpisodeDataSource;", "episodeRequest", "Lcom/platzi/android/rickandmorty/requestmanager/EpisodeRequest;", "(Lcom/platzi/android/rickandmorty/requestmanager/EpisodeRequest;)V", "getEpisodeFromCharacter", "Lio/reactivex/Single;", "", "Lcom/platzi/android/rickandmorty/domain/Episode;", "episodeUrlList", "", "requestmanager_debug"})
public final class EpisodeRetrofitDataSource implements com.platzi.android.rickandmorty.data.RemoteEpisodeDataSource {
    private final com.platzi.android.rickandmorty.requestmanager.EpisodeRequest episodeRequest = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<com.platzi.android.rickandmorty.domain.Episode>> getEpisodeFromCharacter(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> episodeUrlList) {
        return null;
    }
    
    public EpisodeRetrofitDataSource(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.requestmanager.EpisodeRequest episodeRequest) {
        super();
    }
}