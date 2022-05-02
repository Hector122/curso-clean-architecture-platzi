package ORelly

import ORelly.Color.*

var count = 0

fun main() {

    val list = listOf(1, 3, 6, 8, 10)
    println(list.jointToString(list, "(", ";", ")"))

}

fun doSomething() {
    val list = listOf(1, 2, 2, 2, 2, 12, 2, 2, 85, 2, 2, 88)

    val set = hashSetOf("hola", "hola", "ho;a", "Hola", "hola")

    val map = hashMapOf("NOse" to 12, 12 to 7, "Hekk" to 'C')
    println(list.javaClass)
    println(set.javaClass)
    println(map.javaClass)
    println(list.maxOrNull())
    println("Testing".lastChar())
}


fun String.lastChar() = (length - 1)

