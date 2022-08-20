package com.platzi.android.rickandmorty.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.platzi.android.rickandmorty.R
import com.platzi.android.rickandmorty.adapters.CharacterGridAdapter
import com.platzi.android.rickandmorty.api.*
import com.platzi.android.rickandmorty.api.APIConstants.BASE_API_URL
import com.platzi.android.rickandmorty.databinding.FragmentCharacterListBinding
import com.platzi.android.rickandmorty.utils.setItemDecorationSpacing
import com.platzi.android.rickandmorty.utils.showLongToast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_character_list.*


class CharacterListFragment : Fragment() {

    //region Fields

    private lateinit var characterGridAdapter: CharacterGridAdapter
    private lateinit var listener: OnCharacterListFragmentListener
    private lateinit var characterRequest: CharacterRequest

    private val viewModel: CharacterListViewModel by lazy {
        CharacterListViewModel(characterRequest)
    }

    private val onScrollListener: RecyclerView.OnScrollListener by lazy {
        object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                val visibleItemCount: Int = layoutManager.childCount
                val totalItemCount: Int = layoutManager.itemCount
                val firstVisibleItemPosition: Int = layoutManager.findFirstVisibleItemPosition()

                viewModel.onLoadMoreItems(
                    visibleItemCount,
                    firstVisibleItemPosition,
                    totalItemCount
                )
            }
        }
    }

    //endregion

    //region Override Methods & Callbacks

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as OnCharacterListFragmentListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnCharacterListFragmentListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        characterRequest = CharacterRequest(BASE_API_URL)

        return DataBindingUtil.inflate<FragmentCharacterListBinding>(
            inflater,
            R.layout.fragment_character_list,
            container,
            false
        ).apply {
            lifecycleOwner = this@CharacterListFragment
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterGridAdapter = CharacterGridAdapter { character ->
            listener.openCharacterDetail(character)
        }
        characterGridAdapter.setHasStableIds(true)

        rvCharacterList.run {
            addOnScrollListener(onScrollListener)
            setItemDecorationSpacing(resources.getDimension(R.dimen.list_item_padding))

            adapter = characterGridAdapter
        }

        srwCharacterList.setOnRefreshListener {
            viewModel.onRetryGetAllCharacter(rvCharacterList.adapter?.itemCount ?: 0)
        }

        //Hear events
        viewModel.events.observe(viewLifecycleOwner, Observer { events ->
            events?.let { navigation ->
                when (navigation) {
                    is CharacterListViewModel.CharacterListNavigation.ShowCharacterList -> {
                        characterGridAdapter.addData(navigation.characterList)
                    }
                    is CharacterListViewModel.CharacterListNavigation.ShowCharacterListError -> {
                        context?.showLongToast("Error: ${navigation.error.message}")
                    }
                    CharacterListViewModel.CharacterListNavigation.HideLoading -> {
                        srwCharacterList.isRefreshing = false
                    }
                    CharacterListViewModel.CharacterListNavigation.ShowLoading -> {
                        srwCharacterList.isRefreshing = true
                    }
                }
            }
        })

        viewModel.onGetAllCharacters()
    }

    //endregion

    //region Private Methods


    //endregion

    //region Inner Classes & Interfaces

    interface OnCharacterListFragmentListener {
        fun openCharacterDetail(character: CharacterServer)
    }

    //endregion

    //region Companion object

    companion object {

        fun newInstance(args: Bundle? = Bundle()) = CharacterListFragment().apply {
            arguments = args
        }
    }

    //endregion
}
