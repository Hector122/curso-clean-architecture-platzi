import kotlin.random.Random

fun main() {


}

var dirty = 20
val waterFilter: (Int) -> Int = { dirtyXDE -> dirtyXDE / 2 }

//take an argument indicating the number of sides of the dice used for the roll.
var rollDice = {slide: Int -> Random.nextInt(slide) + 1}

//fix the lambda to return 0 if the number of sides passed in is 0.
var rollDice0 = {slide: Int -> if(slide ==0 ) 0 else Random.nextInt(slide) + 1}

//This same lambda using the function type notation.
var rollDice2 : (Int) -> Int = {slide -> if(slide ==0) 0 else Random.nextInt(slide) + 1}

//Create a function gamePlay() that takes a roll of the dice as an argument and prints it out.
fun gamePlay(diceRoll : Int){
    print(diceRoll)
}