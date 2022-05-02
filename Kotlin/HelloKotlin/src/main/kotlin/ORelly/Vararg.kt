package ORelly

fun main(args: Array<String>) {

    //destructuring declaration
    val (name, other) = 1 to "One"

    println(
        """
        $name
        $other
    """.trimIndent()
    )


    val movies = listOf("Terminator", "Alien", "Free guy", *args)

    //using infix notation
    movies sayMayName 4
    "prueba" test "3"
    "Otha  cosa" test movies


    regex()

    println(parsePath("Uers/Yokir/kotlin/charter.adoc"))
}

//Infix
infix fun Any.sayMayName(int: Int) {
}

infix fun String.test(other: Any) = Pair(this, other)


fun regex() {
    //split in kotlin
    val content = "12.345-6.A"
    println(content.split("."))
    println(content.split("\\.|-".toRegex()))
    println(content.split(".", "-"))
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast('/')
    val file = path.substringAfterLast('/')

    val fileName = file.substringBeforeLast('.')
    val fileExt = file.substringAfterLast('.')

    println("Dir: $directory, name: $fileName, ext: $fileExt")
}
