package com.platzi.android.rickandmorty.di

import android.app.Application
import com.platzi.android.rickandmorty.data.RepositoryModule
import com.platzi.android.rickandmorty.databasemanager.DataBaseModule
import com.platzi.android.rickandmorty.requestmanager.ApiModule
import com.platzi.android.rickandmorty.usecases.UseCaseModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApiModule::class,
    DataBaseModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface RickAndMortyPlatziComponent {

    fun inject(module: CharacterListModule): CharacterListModule.CharacterListComponent
    fun inject(module: FavoriteListModule): FavoriteListModule.FavoriteListComponent
  //  fun inject(module: CharacterDetailModule): CharacterDetailComponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): RickAndMortyPlatziComponent
    }
}
