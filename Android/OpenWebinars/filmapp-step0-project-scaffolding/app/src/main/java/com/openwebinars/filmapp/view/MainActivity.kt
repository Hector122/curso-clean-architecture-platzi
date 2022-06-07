package com.openwebinars.filmapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.openwebinars.filmapp.R
import com.openwebinars.filmapp.databinding.ActivityMainBinding
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    private val newsFragment = NewFilmsFragment()
    private val favsFragment = FavsFragment()
    
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(newsFragment)

        setViewBottomNavigationListener()
    }

    private fun setFragment(fragmentToChange: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutFragmentHolder, fragmentToChange)
            .commit()
    }

    private fun setViewBottomNavigationListener() {
        val viewBottomNav = binding.viewBottomNavigation
        viewBottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.news -> setFragment(newsFragment)
                R.id.favs -> setFragment(favsFragment)
            }
            true
        }
    }
}