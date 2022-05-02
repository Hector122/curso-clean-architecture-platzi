package aquarium

fun main(args: Array<String>) {
    delegate()
}


fun delegate() {

    val pleco = PlecostomusInh(RedColor)
    println("Fish has a color ${pleco.color}")
    pleco.eat()
}

interface FishAction2 {
    fun eat()
}

interface FishColor2 {
    val color: String
}


class PlecostomusInh(fishColor: FishColor2 = BlueColor) : FishAction2 by PrintFishAction("A lot of algae"),
    FishColor2 by fishColor

// object make one intance (Singleton)
object BlueColor : FishColor2 {
    override val color = "blue"
}

object RedColor : FishColor2 {
    override val color = "red"
}

class PrintFishAction(val food: String) : FishAction2 {
    override fun eat() {
        println("eat $food")
    }
}

