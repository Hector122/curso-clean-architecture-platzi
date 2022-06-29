package com.example.leonardomoralescoroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.NullPointerException

fun main(){

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("exception $throwable have been cached")
    }

    val scope = CoroutineScope(Job() + exceptionHandler)
    scope.launch {

    }
}


private fun trowException(){
    throw NullPointerException()
}