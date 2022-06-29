package com.example.leonardomoralescoroutines

import kotlinx.coroutines.*
import java.lang.NullPointerException

fun main() {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("exception Handler: $throwable  ...")
    }

    val job = SupervisorJob()
    val scope = CoroutineScope(job + exceptionHandler)

    scope.launch {
        println("Coroutine 1 init")
        delay(200)
        println("Coroutine 1 failed exception...")
        trowException()
    }

    scope.launch {
        println("Coroutine 2 init")
        delay(400)
        println("Coroutine 2 finalized")
    }.invokeOnCompletion {
        if (it is CancellationException){
            println("Coroutine 2 cancel")
        }
    }

    Thread.sleep(1000)
    println("coroutine father still alive... : ${scope.isActive} ")
}

private fun trowException() {
    throw NullPointerException()
}