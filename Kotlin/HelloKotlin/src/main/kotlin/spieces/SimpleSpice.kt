package spieces

class SimpleSpice {
    val name = "Curry"
    var spiciness = "mid"

    val heat: Int
        get() {
            return if (spiciness == "mid") 5 else 0
        }
}

fun main() {
    val simpleSpice = SimpleSpice()
    println("${simpleSpice.name} ${simpleSpice.heat}")

    val spiceCabinet = listOf(
        SpiceContainer(Curry("Curry", "mid")),
        SpiceContainer(Curry("Red Curry", "low")),
        SpiceContainer(Curry("Green Curry", "high"))
    )

    for(index in spiceCabinet){
        println(index.label)
    }
}