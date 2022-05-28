import java.util.*

fun main(args: Array<String>) {
    println("Hello ${args[0]}")
    feedTheFish()
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is ${day} and the fish eat $food")

    println(shouldChangeWater(day))
    shouldChangeWater(day, temperature = 21)
    shouldChangeWater(day, temperature = 22, dirty = 40)

    shouldChangeWater2(day = "monday")

    if (shouldChangeWater(day)) {
        println("")
    }
}

fun shouldChangeWater(day: String, temperature: Int = 23, dirty: Int = 20): Boolean {
    return when {
        isHootTemperature(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isHootTemperature(temperature: Int): Boolean = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "sunday"


fun shouldChangeWater2(temperature: Int = 23, dirty: Int = 20, day: String): Boolean {
    return true
}

fun randomDay(): String {
    val dayOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return dayOfWeek[Random().nextInt(7)]
}


fun fishFood(day: String): String {
    return when (day) {
        "Sunday" -> "Flakes"
        "Monday" -> "Pallets"
        "Tuesday" -> "redworms"
        "Wednesday" -> "granules"
        "Thursday" -> "mosquitoes"
        "Friday" -> "lettuce"
        else -> "fasting"
    }
}


fun fish() {
    val temp = 10
    val isHot = temp > 50

    print(isHot)
}

fun dayOfTheWeek() {
    println("What day is it today?")

    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)


    println(
        when (day) {
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "Time have Stopped"
        }
    )
}