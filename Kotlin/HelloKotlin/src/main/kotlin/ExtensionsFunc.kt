fun main() {

//    val numero = 10;
//    numero.sumaNumeros(20)
//
//    val animal = Animal()
//    animal.printAnimal()

    val sb: StringBuilder  = java.lang.StringBuilder("Kotlin?")
    println(sb.lastChar)
}

//Extension functions
fun Int.sumaNumeros(number: Int) {
    println("La suma es: ${this + number}")
}

class Animal {
    val name: String = "Animal class"
}

fun Animal.printAnimal() {
    println(this.name)
}

//Extension properties
val String.lastChar get() = { this.length - 1 }
var String.lastCharTwo
    get() = length - 5
    set(value) {
        value * 2
    }

var String.lastCharThree: () -> Int
    get() = { this.length - 1 }
    set(value: () -> Int) {
        value()
    }

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }