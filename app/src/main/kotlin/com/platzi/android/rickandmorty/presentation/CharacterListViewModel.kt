package com.platzi.android.rickandmorty.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.usecases.GetAllCharactersUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterListViewModel(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _events = MutableLiveData<CharacterListNavigation>()
    val events: LiveData<CharacterListNavigation> get() = _events

    private val disposable = CompositeDisposable()

    private var currentPage = 1
    private var isLastPage = false
    private var isLoading = false


    override fun onCleared() {
        super.onCleared()

        disposable.clear()
    }

    fun onLoadMoreItems(
        visibleItemCount: Int,
        firstVisibleItemPosition: Int,
        totalItemCount: Int
    ) {
        if (isLoading || isLastPage || !isInFooter(
                visibleItemCount,
                firstVisibleItemPosition,
                totalItemCount
            )
        ) {
            return
        }

        currentPage += 1
        onGetAllCharacters()
    }

    private fun isInFooter(
        visibleItemCount: Int,
        firstVisibleItemPosition: Int,
        totalItemCount: Int
    ): Boolean {
        return visibleItemCount + firstVisibleItemPosition >= totalItemCount
                && firstVisibleItemPosition >= 0
                && totalItemCount >= PAGE_SIZE
    }

    fun onRetryGetAllCharacter(itemCount: Int) {
        if (itemCount > 0) {
            //srwCharacterList.isRefreshing = false
            _events.value = CharacterListNavigation.HideLoading
            return
        }

        onGetAllCharacters()
    }

    fun onGetAllCharacters() {
        disposable.add(
            getAllCharactersUseCase.invoke(currentPage)
                .doOnSubscribe {
                    //srwCharacterList.isRefreshing = true
                    _events.value = CharacterListNavigation.ShowLoading
                }
                .subscribe({ characterList ->
                    if (characterList.size < PAGE_SIZE) {
                        isLastPage = true
                    }

//                    srwCharacterList.isRefreshing = false
//                    characterGridAdapter.addData(characterList)
                    _events.value = CharacterListNavigation.HideLoading
                    _events.value = CharacterListNavigation.ShowCharacterList(characterList)
                }, { error ->
                    isLastPage = true
//                    srwCharacterList.isRefreshing = false
//                    context?.showLongToast("Error -> ${error.message}")
                    _events.value = CharacterListNavigation.HideLoading
                    _events.value = CharacterListNavigation.ShowCharacterListError(error)

                })
        )
    }

    companion object {
        private const val PAGE_SIZE = 20
    }

    sealed class CharacterListNavigation {
        data class ShowCharacterListError(val error: Throwable) : CharacterListNavigation()
        data class ShowCharacterList(val characterList: List<Character>) :
            CharacterListNavigation()

        object HideLoading : CharacterListNavigation()
        object ShowLoading : CharacterListNavigation()
    }
}