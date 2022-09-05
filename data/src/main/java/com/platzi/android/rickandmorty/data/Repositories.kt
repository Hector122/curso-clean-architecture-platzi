package com.platzi.android.rickandmorty.data

import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.domain.Episode
import io.reactivex.Single

class CharacterRepository(
    private val remoteCharacterDataSource: RemoteCharacterDataSource,
    private val localCharacterDataSource: LocalCharacterDataSource
) {
    fun getAllCharacters(page: Int) = remoteCharacterDataSource.getAllCharacters(page)

    fun getAllFavoriteCharacters() = localCharacterDataSource.getAllFavoriteCharacters()

    fun getFavoriteCharacterStatus(characterId: Int) = localCharacterDataSource.getFavoriteCharacterStatus(characterId)

    fun updateFavoriteCharacterStatus(character: Character) = localCharacterDataSource.updateFavoriteCharacterStatus(character)
}

class EpisodeRepository(
    private val remoteEpisodeDataSource: RemoteEpisodeDataSource
) {
    fun getEpisodeFromCharacter(episodeUrlList: List<String>): Single<List<Episode>> =
        remoteEpisodeDataSource.getEpisodeFromCharacter(episodeUrlList)
}

