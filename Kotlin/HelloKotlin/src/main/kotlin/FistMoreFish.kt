//fitMoreFish function
//Create a function that takes these arguments:
//
//tankSize (in gallons)
//currentFish (a list of Ints representing the length of each fish currently in the tank)
//fishSize (the length of the new fish we want to add to the tank)
//hasDecorations (true if the the tank has decorations, false if not)

//For example:
//A 10 gallon tank with decorations can hold up to 8 inches of fish, for example 4 x 2-inch-long fish.
//A 20 gallon tank without decorations can hold up to 20 inches of fish, for example 6 x 1-inch-long fish and 2 x 2-inch-long fish.

//fitMoreFish function
//Create a function that takes these arguments:
//
//tankSize (in gallons)
//currentFish (a list of Ints representing the length of each fish currently in the tank)
//fishSize (the length of the new fish we want to add to the tank)
//hasDecorations (true if the the tank has decorations, false if not)
//You can assume that typically a tank has decorations, and that a typical fish is 2 inches long. That means you can set those values as default parameters.
//
//Output
//Make sure you test your code against the following calls, and that you get the correct output for each.
//
//canAddFish(10.0, listOf(3,3,3)) ---> false
//canAddFish(8.0, listOf(2,2,2), hasDecorations = false) ---> true
//canAddFish(9.0, listOf(1,1,3), 3) ---> false
//canAddFish(10.0, listOf(), 7, true) ---> true
fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {

    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum().plus(fishSize))

//    val realTankSize = if (hasDecorations) (tankSize * .80).toInt() else tankSize.toInt()
//
//    var countFish = 0
//    for (index in currentFish) {
//        countFish += index
//    }
//
//    return realTankSize >= countFish.plus(fishSize)
}

fun main(args: Array<String>) {
    println(canAddFish(10.0, listOf(3, 3, 3)))
   println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1, 1, 3), 3))
    println(canAddFish(10.0, listOf(), 7, true))
}


