package aquarium

fun main(args: Array<String>) {
    buildAquarium();
}

fun buildAquarium() {
    val myAquarium = Aquarium()

    println(
        "Length: ${myAquarium.length} " +
                "With: ${myAquarium.width} " +
                "Height: ${myAquarium.height} "
    )

    myAquarium.height = 80
    println(" new height: ${myAquarium.height}cm")
    println(" new height: ${myAquarium.volume}L")

    var smallAquarium = Aquarium(20, width = 14, height = 30)
    println(" small aquarium ${smallAquarium.volume} L")

    var myAquarium2 = Aquarium(numberOfFish = 9)
    var towerTank = TowerTank()
    towerTank.water


    println(
        " small aquarium 2: ${myAquarium2.volume} " +
                "Length: ${myAquarium2.length} " +
                "With: ${myAquarium2.width} " +
                "Height: ${myAquarium2.height} "
    )
}

fun makeFish(){
    val shark = Shark()
    val pleco = Plecostomus()

    shark.eat()
    pleco.eat()

    println("Shark color:${shark.color} \n  ${pleco.color}")
}

fun feedFish(fish: FishAction){
    //make some foot
    fish.eat()
}
