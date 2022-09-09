package com.platzi.android.rickandmorty.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.domain.Episode
import com.platzi.android.rickandmorty.usecases.GetEpisodeFromCharacterUseCase
import com.platzi.android.rickandmorty.usecases.GetFavoriteCharacterStatusUseCase
import com.platzi.android.rickandmorty.usecases.UpdateFavoriteCharacterStatusUseCase
import io.reactivex.disposables.CompositeDisposable

class CharacterDetailViewModel(
    private val character: Character?,
    private val getFavoriteCharacterStatusUseCase: GetFavoriteCharacterStatusUseCase,
    private val updateFavoriteCharacterStatusUseCase: UpdateFavoriteCharacterStatusUseCase,
    private val getEpisodeFromCharacterUseCase: GetEpisodeFromCharacterUseCase
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _characterValidations = MutableLiveData<Character>()
    val characterValidations: LiveData<Character> get() = _characterValidations

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    private val _events = MutableLiveData<Events<CharacterDetailNavigation>>()
    val events: LiveData<Events<CharacterDetailNavigation>> get() = _events

    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }

    fun onCharacterValidation() {
        if (character == null) {
            _events.value = Events(CharacterDetailNavigation.CloseActivity)
            return
        }

        _characterValidations.value = character
        validateFavoriteCharacterStatus(character.id)
        requestShowEpisodeList(character.episodeList)
    }


    fun onUpdateFavoriteCharacterStatus() {
        //val characterEntity: CharacterEntity = character!!.toCharacterEntity()
        disposable.add(
           //updateFavoriteCharacterStatusUseCase.invoke(characterEntity)
            updateFavoriteCharacterStatusUseCase.invoke(character!!)
                .subscribe { isFavorite ->
                    _isFavorite.value = isFavorite
                    //updateFavoriteIcon(isFavorite)
                }
        )
    }

    private fun validateFavoriteCharacterStatus(characterId: Int) {
        disposable.add(
            getFavoriteCharacterStatusUseCase.invoke(characterId)
//            characterDao.getCharacterById(characterId)
//                .isEmpty
//                .flatMapMaybe { isEmpty ->
//                    Maybe.just(!isEmpty)
//                }
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
                .subscribe { isFavorite ->
                    _isFavorite.value = isFavorite
                    //updateFavoriteIcon(isFavorite)
                }
        )
    }

    private fun requestShowEpisodeList(episodeUrlList: List<String>) {
        disposable.add(
            // move to use case
//            Observable.fromIterable(episodeUrlList)
//                .flatMap { episode: String ->
//                    episodeRequest.baseUrl = episode
//                    episodeRequest
//                        .getService<EpisodeService>()
//                        .getEpisode()
//                        .toObservable()
//                }
//                .toList()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
            getEpisodeFromCharacterUseCase.invoke(episodeUrlList)
                .doOnSubscribe {
                    //episodeProgressBar.isVisible = true
                    _events.value = Events(CharacterDetailNavigation.ShowEpisodeListLoading)

                }
                .subscribe(
                    { episodeList ->
//                        episodeProgressBar.isVisible = false
//                        episodeListAdapter.updateData(episodeList)
                        _events.value = Events(CharacterDetailNavigation.HideEpisodeListLoading)
                        _events.value =
                            Events(CharacterDetailNavigation.ShowEpisodeList(episodeList))
                    },
                    { error ->
//                        episodeProgressBar.isVisible = false
//                        this@CharacterDetailActivity.showLongToast("Error -> ${error.message}")
                        _events.value = Events(CharacterDetailNavigation.HideEpisodeListLoading)
                        _events.value = Events(CharacterDetailNavigation.ShowEpisodeError(error))
                    })
        )
    }

    sealed class CharacterDetailNavigation {
        data class ShowEpisodeError(val error: Throwable) : CharacterDetailNavigation()
        data class ShowEpisodeList(val episodeList: List<Episode>) :
            CharacterDetailNavigation()

        object CloseActivity : CharacterDetailNavigation()
        object HideEpisodeListLoading : CharacterDetailNavigation()
        object ShowEpisodeListLoading : CharacterDetailNavigation()
    }
}