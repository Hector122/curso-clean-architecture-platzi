package decorations

fun main() {
    makeDecorations()
}

fun makeDecorations() {
    val v1 = Decorations("granite")
    println(v1.rocks)

    val v2 = Decorations("slate")

    val v3 = Decorations("slate")

    println("v1 == v2: " + (v1.equals(v2))) // false
    println("v2 == v3: " + (v2.equals(v3))) //true

    val v4 = v3.copy()
    println(v3)
    println(v4)

    var v5 = Decorations2("crystal", "wood", "drover")
    println(v5)


    //using recomposition.
    val (rocks, wood, driverFF) = v5
    println(rocks)
    println(wood)
    println(driverFF)


}

data class Decorations(var rocks: String)

data class Decorations2(var rocks: String, var wood: String, var diver: String)