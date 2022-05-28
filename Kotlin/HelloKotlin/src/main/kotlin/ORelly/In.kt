package ORelly

fun main() {
    println(isNotDigit('9'))
    println(isNotDigit('C'))
    println(isLetter('x'))
    println(isLetter('2'))

    println("Kotlin" in "Java".."Scala")
    println("Java" in setOf("Java", "Scala"))
}

fun isNotDigit(char: Char) = char !in '0'..'9'
fun isLetter(char: Char) = char in 'a'..'z' || char in 'A'..'Z'