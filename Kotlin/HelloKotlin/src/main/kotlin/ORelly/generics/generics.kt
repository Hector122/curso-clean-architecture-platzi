package ORelly.generics

enum class FurColor {
    BLACK, YELLOW
}

open class Base(p: Int)

class Derived(p: Int) : Base(p)

open class Animal( id: Int, name: String)

class Bird(id: Int, name: String) : Animal(id, name)

data class Dog(val id: Int, var name: String, val furColor: FurColor) : Animal(id, name)

data class Cat(var id: Int, var name: String, val eyeColor: FurColor) : Animal(id, name)

class Cage<T : Animal>(val animal: T, val size: Double)

class CovariantCage<out T : Animal>(val t: T?, val size: Double) {
//    fun getId(): Int? = t?.id
//    fun getName(): String? = t?.name
//    fun getContentType(): T? = t?.let { t } ?: run { null }
//    fun printAnimalInfo(): String = "Animal ${t?.id} is called ${t?.name}"
}

fun main() {
    val dog = Dog(1, "Firulay", FurColor.BLACK)
    val cageDog = Cage(dog, 6.0)

    val cat = Cat(4, "Misu-misu", eyeColor = FurColor.YELLOW)
    var cageCat = Cage(cat, 4.0)

    println("The name is ${cageDog.animal.name}, and the size: ${cageDog.size}")
    println("The name is ${cageCat.animal.name}, and the size: ${cageCat.size}")

    // Not valid thanks 'generic constraint.'  -> <T:Animal>
//    val cageString = Cage("This cage is host String?", 5.0)
//    println("The name is ${cageString.t.na}, and the size: ${cageString.size}")


    val cageAnimal: Cage<Animal>
    val cageDog2: Cage<Dog> = Cage(animal = dog, size = 7.9)
    //cageAnimal = cageDog2


}