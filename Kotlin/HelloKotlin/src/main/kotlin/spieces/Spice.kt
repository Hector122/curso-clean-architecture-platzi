package spieces

/*


2 - Add a variable, heat, to your class, with a getter that returns a numeric value for each type of spiciness.
3- Instead of the list of spices as Strings you used earlier, create a list of Spice objects and give each object a name and a spiciness level.
4 - Add an init block that prints out the values for the object after it has been created. Create a spice.
Create a list of spices that are spicy or less than spicy. Hint: Use a filter and the heat property.
Because salt is a very common spice, create a helper function called makeSalt().
 */
sealed class Spice(
    var name: String, spiciness: String = "mild",
    color: SpiceColor
) : SpiceColor by color {
    abstract fun prepareSpice()
}

//Curry can have varying levels of spiciness, so we don't want to use the default value, but rather pass in the spiciness value.
class Curry(
    name: String, spiciness: String,
    color: SpiceColor = YellowSpiceColor
) : Spice(name, spiciness, color),
    Grinder, SpiceColor by color {

    override fun grind() {
        TODO("Not yet implemented")
    }

    override fun prepareSpice() {
        grind()
    }

    fun printColor() {
        println("color:$color")
    }
}

interface Grinder {
    fun grind()
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}


enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00);
}

fun delegate() {
    var curry = Curry("Curry", "mid")
    curry.printColor()
}

fun main() {
    delegate()

/////
//
//    val heat: Int
//        get() {
//            return when (spiciness) {
//                "mild" -> 1
//                "medium" -> 3
//                "spicy" -> 5
//                "very spicy" -> 7
//                "extremely spicy" -> 10
//                else -> 0
//            }
//        }
//
//    init {
//        println("${this.name} spiciness level ${this.heat}")
//    }


//    val spice1 = listOf(
//        Spice("curry", "mild"),
//        Spice("pepper", "medium"),
//        Spice("cayenne", "spicy"),
//        Spice("ginger", "mild"),
//        Spice("red curry", "medium"),
//        Spice("green curry", "mild"),
//        Spice("hot pepper", "extremely spicy")
//    )
//
//    var spice = Spice("curry", "medium")
//
//    var listOfSpices = spice1.filter { it.heat < 5 }
//    println(listOfSpices)
}