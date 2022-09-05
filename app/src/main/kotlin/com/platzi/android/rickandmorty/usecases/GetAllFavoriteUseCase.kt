package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.data.CharacterRepository
import com.platzi.android.rickandmorty.database.CharacterDao
import com.platzi.android.rickandmorty.database.CharacterEntity
import com.platzi.android.rickandmorty.database.toCharacterDomain
import com.platzi.android.rickandmorty.database.toCharacterDomainList
import io.reactivex.schedulers.Schedulers

class GetAllFavoriteUseCase(
    //private val characterDao: CharacterDao
    private val characterRepository: CharacterRepository) {

//    fun invoke() = characterDao
//        .getAllFavoriteCharacters()
//        .map (List<CharacterEntity>::toCharacterDomainList)
//        .onErrorReturn { emptyList() }
//        .subscribeOn(Schedulers.io())

    fun invoke() = characterRepository.getAllFavoriteCharacters()
}