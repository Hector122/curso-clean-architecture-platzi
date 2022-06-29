package com.example.leonardomoralescoroutines

import kotlinx.coroutines.*
import java.lang.RuntimeException

fun main() = runBlocking {

    val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Exception catch")
    }

    val coroutineScope = CoroutineScope(Dispatchers.Unconfined + coroutineExceptionHandler)

    val job1 = coroutineScope.launch {
        println("Job 1 started")
        delay(100)

        //this.cancel()
        throw RuntimeException()
        println("Job 1 finished")
    }

    val job2 = coroutineScope.launch {
        println("Job 2 started")
        delay(200)
        println("Job 2 finished")
    }

    Thread.sleep(2000)
    println("Job1 -> : ${job1.status()}")
    println("Job2 -> : ${job2.status()}")
    println("Father Job status : ${coroutineScope.isActive}")
}

fun Job.status(): String = when {
    isCancelled -> "Cancelled"
    isCompleted -> "Complete"
    isActive -> "Active"
    else -> "Nothing"

}