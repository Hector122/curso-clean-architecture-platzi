package com.platzi.android.rickandmorty.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.android.rickandmorty.database.CharacterDao
import com.platzi.android.rickandmorty.database.CharacterEntity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FavoriteListViewModel(private val characterDao: CharacterDao) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _events = MutableLiveData<Events<FavoriteListNavigation>>()
    val events: LiveData<Events<FavoriteListNavigation>> get() = _events

    private val _favoriteCharacterList: LiveData<List<CharacterEntity>>
        get() = LiveDataReactiveStreams.fromPublisher(
            characterDao
                .getAllFavoriteCharacters()
                .onErrorReturn { emptyList() }
                .subscribeOn(Schedulers.io())
        )

    val favoriteCharacterList: LiveData<List<CharacterEntity>>
        get() = _favoriteCharacterList

    // private val _favoriteCharacterList: LiveData<List<CharacterEntity>>
    //get() = Live


    /*
        disposable.add(
            characterDao.getAllFavoriteCharacters()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ characterList ->
                    if(characterList.isEmpty()) {
                        tvEmptyListMessage.isVisible = true
                        favoriteListAdapter.updateData(emptyList())
                    } else {
                        tvEmptyListMessage.isVisible = false
                        favoriteListAdapter.updateData(characterList)
                    }
                },{
                    tvEmptyListMessage.isVisible = true
                    favoriteListAdapter.updateData(emptyList())
                })
        )
     */

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun onFavoriteCharacterList(list: List<CharacterEntity>) {
        if (list.isEmpty()) {
            _events.value = Events(FavoriteListNavigation.ShowEmptyListMessage)
            return
        }
        _events.value = Events(FavoriteListNavigation.ShowCharacterList(list))
    }

    sealed class FavoriteListNavigation {
        data class ShowCharacterList(val characterList: List<CharacterEntity>) :
            FavoriteListNavigation()

        object ShowEmptyListMessage : FavoriteListNavigation()
    }
}