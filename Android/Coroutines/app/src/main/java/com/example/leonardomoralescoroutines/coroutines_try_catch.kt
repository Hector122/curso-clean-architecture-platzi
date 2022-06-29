package com.example.leonardomoralescoroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.NullPointerException

fun main(){

    val scope = CoroutineScope(Job())

    scope.launch {
        try {
            launch {
                trowException()
            }

        } catch (e : Exception) {
            print("Catch exeption: $e")
        }

    }

    Thread.sleep(500)
}

private fun trowException(){
    throw NullPointerException()
}