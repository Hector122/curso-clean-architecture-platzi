package com.example.leonardomoralescoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

//fun main(){
//
//    println("function main init")
//
//    runBlocking {
//        launch { suspendTaskOne()  }
//        launch {  suspendTaskTwo() }
//
//        println("Call task 1 and 2 from subprocess: ${Thread.currentThread().name}")
//    }
//
//    println("function main finalized")
//}

suspend fun suspendTaskOne(){
    println("suspend fun task 1  init in subprocess: ${Thread.currentThread().name}")
   yield() // cede el thread de la coroutine to another coroutine.
    println("suspend fun task 1  finalized in subprocess: ${Thread.currentThread().name}")
}

suspend fun suspendTaskTwo(){
    //delay(5000)
    println("suspend fun task 2  init in subprocess: ${Thread.currentThread().name}")
   yield() // cede el thread de la coroutine to another coroutine.
    println("suspend fun task 2  finalized in subprocess: ${Thread.currentThread().name}")
}