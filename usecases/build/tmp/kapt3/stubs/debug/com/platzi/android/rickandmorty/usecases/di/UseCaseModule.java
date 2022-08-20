package com.platzi.android.rickandmorty.usecases.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/platzi/android/rickandmorty/usecases/di/UseCaseModule;", "", "()V", "getAllCharacterUseCaseProvider", "Lcom/platzi/android/rickandmorty/usecases/GetAllCharactersUseCase;", "characterRepository", "Lcom/platzi/android/rickandmorty/data/CharacterRepository;", "getAllFavoriteCharactersUseCaseProvider", "Lcom/platzi/android/rickandmorty/usecases/GetAllFavoriteCharactersUseCase;", "getEpisodeFromCharacterUseCaseProvider", "Lcom/platzi/android/rickandmorty/usecases/GetEpisodeFromCharacterUseCase;", "episodeRepository", "Lcom/platzi/android/rickandmorty/data/EpisodeRepository;", "getFavoriteCharacterStatusUseCaseProvider", "Lcom/platzi/android/rickandmorty/usecases/GetFavoriteCharacterStatusUseCase;", "updateFavoriteCharacterStatusUseCaseProvider", "Lcom/platzi/android/rickandmorty/usecases/UpdateFavoriteCharacterStatusUseCase;", "usecases_debug"})
@dagger.Module()
public final class UseCaseModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.usecases.GetAllCharactersUseCase getAllCharacterUseCaseProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.CharacterRepository characterRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.usecases.GetAllFavoriteCharactersUseCase getAllFavoriteCharactersUseCaseProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.CharacterRepository characterRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.usecases.GetFavoriteCharacterStatusUseCase getFavoriteCharacterStatusUseCaseProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.CharacterRepository characterRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.usecases.UpdateFavoriteCharacterStatusUseCase updateFavoriteCharacterStatusUseCaseProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.CharacterRepository characterRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.platzi.android.rickandmorty.usecases.GetEpisodeFromCharacterUseCase getEpisodeFromCharacterUseCaseProvider(@org.jetbrains.annotations.NotNull()
    com.platzi.android.rickandmorty.data.EpisodeRepository episodeRepository) {
        return null;
    }
    
    public UseCaseModule() {
        super();
    }
}