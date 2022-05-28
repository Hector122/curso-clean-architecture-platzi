package ORelly

import java.lang.Exception


class Person(val name: String) {
    val enum = 9
}

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0), YELLOW(255, 255, 0), GREEN(0, 255, 0);

    fun rgb(): Int {
        return (r * 256 + g) * 256 + b
    }
}

// Rainbow color mnemonic: "Richard Of York Give Battle In Vain"
fun getMnemonic(color: Color): String = when (color) {
    Color.RED -> "Richard"
    Color.ORANGE -> "Of"
    Color.YELLOW -> "York"
    Color.GREEN -> "Give"
    Color.RED -> "Duplicate"
}


fun getWarmth(color: Color) = when (color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "Warm"
    Color.GREEN -> "cold"
}

fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
    setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
    setOf(Color.YELLOW, Color.GREEN) -> Color.RED
    else -> throw Exception("Dirty color")
}


fun main() {
    val person = Person("Test")
    print(mix(Color.YELLOW, Color.RED))
}
