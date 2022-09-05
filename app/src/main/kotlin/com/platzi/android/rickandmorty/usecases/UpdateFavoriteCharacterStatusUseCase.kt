package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.data.CharacterRepository
import com.platzi.android.rickandmorty.database.CharacterDao
import com.platzi.android.rickandmorty.database.CharacterEntity
import com.platzi.android.rickandmorty.database.toCharacterEntity
import com.platzi.android.rickandmorty.domain.Character
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UpdateFavoriteCharacterStatusUseCase(
    //private val characterDao: CharacterDao
    private val characterRepository: CharacterRepository
) {

    fun invoke(character: Character): Maybe<Boolean> {
       return characterRepository.updateFavoriteCharacterStatus(character)
    }
}