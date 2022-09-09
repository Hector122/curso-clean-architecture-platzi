package com.platzi.android.rickandmorty

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.platzi.android.rickandmorty.di.RickAndMortyPlatziComponent

class RickAndMortyPlatziApp: Application() {

    //region Override Methods & Callbacks

private lateinit var component: RickAndMortyPlatziComponent

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        component = initAppComponent()
    }

    //endregion
    private fun initAppComponent() = DaggerRickAndMortyComponent.factory().create(this)

}
