package com.example.leonardomoralescoroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private val _progressBar = MutableStateFlow(0)
    val progressBar: StateFlow<Int> = _progressBar

    fun startProgressbar(){
        viewModelScope.launch {
            for(i in 1..100){
                _progressBar.value += 1
                delay(30)
            }
        }
    }

    fun restartProgressbar(){
        _progressBar.value = 0
    }
}