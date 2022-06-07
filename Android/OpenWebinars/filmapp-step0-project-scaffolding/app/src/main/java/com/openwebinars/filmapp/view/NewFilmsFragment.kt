package com.openwebinars.filmapp.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.openwebinars.filmapp.R
import com.openwebinars.filmapp.data.FilmsProvider
import com.openwebinars.filmapp.databinding.FragmentNewFilmsBinding
import com.openwebinars.filmapp.view.DetailFragment.Companion.EXTRA

class NewFilmsFragment : Fragment() {
    
    private var _binding: FragmentNewFilmsBinding? = null
    private val binding get() =  _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewFilmsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        with(binding.recyclerNews) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = FilmsAdapter(FilmsProvider.get()) {
                val intentDetail = Intent(context, DetailActivity::class.java)
                intentDetail.putExtra(EXTRA, it)
                startActivity(intentDetail)
            }
        }
    }
}