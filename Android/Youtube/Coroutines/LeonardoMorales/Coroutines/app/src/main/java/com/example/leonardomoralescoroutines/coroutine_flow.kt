package com.example.leonardomoralescoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {
    //emitAndCollectWithFlow()
    flowOfCombine()
}

private suspend fun emitAndCollectWithFlow() {
    val flow = flow<String> {
        for (i in 1..10) {
            delay(100)
            emit("Flow #$i")
        }
    }

    val time = measureTimeMillis {
        flow.buffer().collect {
            delay(300)
            println(it)
        }
    }
    println("time to collect $time")
}

suspend fun flowOfCombine() {
    val numeros = flowOf(1, 2, 3).onEach { delay(1000) }
    val letras = flowOf("A", "B", "C", "D").onEach { delay(2000) }

    numeros.combine(letras) { numero, letra ->
        "$numero - $letra"
    }.collect {
        println(it)
    }
}