package com.platzi.android.rickandmorty.presentation

class Events<out T>(private val content: T) {

    var hasBeenHandler = false

    fun getContentIfNotHandle(): T? =
        if (hasBeenHandler) {
            null
        } else {
            hasBeenHandler = true
            content
        }
}