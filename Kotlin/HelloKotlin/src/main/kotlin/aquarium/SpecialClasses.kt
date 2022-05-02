package aquarium

//Singleton Class
object MobyDick {
    val author = "Herman Melville"

    fun jump() {

    }
}

enum class Color(rgb: Int) {
    BLUE(4),
    GREEN(6),
    RED(1213),
}

//Is a class that can be subclass, but only in the file that is declare.
sealed class Sealed

class SeaLion : Sealed()

class Walrus : Sealed()


fun matchSeal(sealed: Sealed): String {
    return when (sealed) {
        is SeaLion -> "Sea lion class"
        is Walrus -> "Walrus class"
    }
}