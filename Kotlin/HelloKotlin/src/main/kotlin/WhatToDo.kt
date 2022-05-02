import ORelly.TalkativeButton

fun main(args: Array<String>) {

    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    print("How is you mood today?: ")
    print(whatShouldIDoToday(readLine()!!))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        isHappyAndSunny(mood, weather) -> "go for a walk"
        isSadAndRainy(mood, weather, temperature) -> "stay in bed"
        isVeryHot(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun isHappyAndSunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"

fun isSadAndRainy(mood: String, weather: String, temperature: Int) =
    mood == "sad" && weather == "rainy" && temperature == 0

fun isVeryHot(temperature: Int) = temperature > 35

