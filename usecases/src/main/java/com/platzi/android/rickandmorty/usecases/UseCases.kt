package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.data.CharacterRepository
import com.platzi.android.rickandmorty.data.EpisodeRepository
import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.domain.Episode
import io.reactivex.Maybe
import io.reactivex.Single

class GetAllCharactersUseCase(private val characterRepository: CharacterRepository) {
    fun invoke(currentPage: Int) = characterRepository.getAllCharacters(currentPage)
}

class GetAllFavoriteUseCase(private val characterRepository: CharacterRepository) {
    fun invoke() = characterRepository.getAllFavoriteCharacters()
}

class GetEpisodeFromCharacterUseCase(private val episodeRepository: EpisodeRepository) {
    fun invoke(episodeUrlList: List<String>): Single<List<Episode>> =
        episodeRepository.getEpisodeFromCharacter(episodeUrlList)
}

class GetFavoriteCharacterStatusUseCase(private val characterRepository: CharacterRepository) {
    fun invoke(characterId: Int): Maybe<Boolean> {
        return  characterRepository.getFavoriteCharacterStatus(characterId)
    }
}

class UpdateFavoriteCharacterStatusUseCase(private val characterRepository: CharacterRepository) {
    fun invoke(character: Character): Maybe<Boolean> {
        return characterRepository.updateFavoriteCharacterStatus(character)
    }
}