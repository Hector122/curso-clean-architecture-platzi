import java.util.*

fun main(args: Array<String>) {
    var fortune: String = ""
    while (!fortune.contains("Take it easy and enjoy life!")) {
        fortune = getFortuneCookie(getBirthday())
        println("\nYour fortune is: $fortune")
    }

//    var x = 0;
//    while (x < 10) {
//        val fortune = getFortuneCookie(getBirthday())
//        print("Your fortune is: $fortune")
//
//        if (fortune.contains("Take it easy and enjoy life!")) break
//        x = x.inc()
//    }


//    for (index in 1..10) {
//        val fortune = getFortuneCookie(getBirthday())
//        print("$index Your fortune is: $fortune")
//
//        if (fortune.contains("Take it easy and enjoy life!")) break
//    }
}

fun getBirthday(): Int {
    print("\nEnter your birthday: ")

    return readLine()?.toIntOrNull() ?: 1
}

fun getFortuneCookie(birthday: Int): String {
    val fortune = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    return when (birthday) {
        in 0..5 -> fortune[0]
        in 6..10 -> fortune[1]
        28, 31 -> fortune[3]
        else -> fortune[5]
    }
}