package com.platzi.android.rickandmorty.usecases

import com.platzi.android.rickandmorty.data.CharacterRepository
import com.platzi.android.rickandmorty.database.CharacterDao
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetFavoriteCharacterStatusUseCase(
    //val characterDao: CharacterDao
    val characterRepository: CharacterRepository) {

//    fun invoke(characterId: Int): Maybe<Boolean> {
//       return  characterDao.getCharacterById(characterId)
//            .isEmpty
//            .flatMapMaybe { isEmpty ->
//                Maybe.just(!isEmpty)
//            }
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//    }

    fun invoke(characterId: Int): Maybe<Boolean> {
        return  characterRepository.getFavoriteCharacterStatus(characterId)
    }
}