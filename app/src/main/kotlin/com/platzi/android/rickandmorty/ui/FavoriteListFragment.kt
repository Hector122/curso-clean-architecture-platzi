package com.platzi.android.rickandmorty.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.platzi.android.rickandmorty.R
import com.platzi.android.rickandmorty.adapters.FavoriteListAdapter
import com.platzi.android.rickandmorty.data.CharacterRepository
import com.platzi.android.rickandmorty.data.LocalCharacterDataSource
import com.platzi.android.rickandmorty.data.RemoteCharacterDataSource
import com.platzi.android.rickandmorty.database.CharacterDao
import com.platzi.android.rickandmorty.databasemanager.CharacterDatabase
import com.platzi.android.rickandmorty.databasemanager.CharacterRoomDataSource
import com.platzi.android.rickandmorty.databinding.FragmentFavoriteListBinding
import com.platzi.android.rickandmorty.di.FavoriteListModule
import com.platzi.android.rickandmorty.domain.Character
import com.platzi.android.rickandmorty.presentation.FavoriteListViewModel
import com.platzi.android.rickandmorty.requestmanager.APIConstants
import com.platzi.android.rickandmorty.requestmanager.CharacterRequest
import com.platzi.android.rickandmorty.requestmanager.CharacterRetrofitDataSource
import com.platzi.android.rickandmorty.usecases.GetAllFavoriteCharactersUseCase
import com.platzi.android.rickandmorty.utils.getViewModel
import com.platzi.android.rickandmorty.utils.setItemDecorationSpacing
import kotlinx.android.synthetic.main.fragment_favorite_list.*

class FavoriteListFragment : Fragment() {

    //region Fields

    private lateinit var favoriteListAdapter: FavoriteListAdapter
    private lateinit var listener: OnFavoriteListFragmentListener

    // remove with dagger Start

    private val characterRequest: CharacterRequest by lazy {
        CharacterRequest(APIConstants.BASE_API_URL)
    }
    private lateinit var characterDao: CharacterDao
    private val localCharacterDataSource: LocalCharacterDataSource by lazy {
        CharacterRoomDataSource(CharacterDatabase.getDatabase(activity!!.applicationContext))
    }

    private val remoteCharacterDataSource: RemoteCharacterDataSource by lazy {
        CharacterRetrofitDataSource(characterRequest)
    }

    private val characterRepository: CharacterRepository by lazy {
        CharacterRepository(remoteCharacterDataSource, localCharacterDataSource)
    }

    private val getAllFavoriteUseCase: GetAllFavoriteCharactersUseCase by lazy {
       // GetAllFavoriteUseCase(characterDao)
        GetAllFavoriteCharactersUseCase(characterRepository)

    }

    // remove with dagger Start

   // private lateinit var favoriteListComponent: FavoriteListModule.FavoriteListComponent

    private val viewModel: FavoriteListViewModel by lazy {
        // FavoriteListViewModel(characterDao)
        FavoriteListViewModel(getAllFavoriteUseCase)
       // getViewModel { favoriteListComponent.favoriteListViewModel }
    }

    //endregion

    //region Override Methods & Callbacks

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as OnFavoriteListFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnFavoriteListFragmentListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //favoriteListComponent = context!!.app.component.inject(FavoriteListModule())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //characterRequest = CharacterRequest(BASE_API_URL)
        //characterDao = CharacterDatabase.getDatabase(activity!!.applicationContext).characterDao()

        return DataBindingUtil.inflate<FragmentFavoriteListBinding>(
            inflater,
            R.layout.fragment_favorite_list,
            container,
            false
        ).apply {
            lifecycleOwner = this@FavoriteListFragment
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteListAdapter = FavoriteListAdapter { character ->
            listener.openCharacterDetail(character)
        }
        favoriteListAdapter.setHasStableIds(true)

        rvFavoriteList.run {
            setItemDecorationSpacing(resources.getDimension(R.dimen.list_item_padding))
            adapter = favoriteListAdapter
        }

        viewModel.favoriteCharacterList.observe(viewLifecycleOwner, Observer {
            viewModel.onFavoriteCharacterList(it)
        })

        viewModel.events.observe(viewLifecycleOwner, Observer { events ->
            events?.getContentIfNotHandle().let { navigation ->
                when (navigation) {
                    is FavoriteListViewModel.FavoriteListNavigation.ShowCharacterList -> {
                        tvEmptyListMessage.isVisible = false
                        favoriteListAdapter.updateData(navigation.characterList)
                    }
                    FavoriteListViewModel.FavoriteListNavigation.ShowEmptyListMessage -> {
                        tvEmptyListMessage.isVisible = true
                        favoriteListAdapter.updateData(emptyList())
                    }
                    else -> {}
                }
            }
        })


    }


    //endregion

    //region Private Methods

    //endregion

    //region Inner Classes & Interfaces

    interface OnFavoriteListFragmentListener {
        fun openCharacterDetail(character: Character)
    }

    //endregion

    //region Companion object

    companion object {

        fun newInstance(args: Bundle? = Bundle()) = FavoriteListFragment().apply {
            arguments = args
        }
    }

    //endregion

}
