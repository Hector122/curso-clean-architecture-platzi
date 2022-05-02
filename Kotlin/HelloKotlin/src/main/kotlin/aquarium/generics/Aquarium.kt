package aquarium.generics

open class WaterSupply(var needsPrecessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalsCleaners() {
        needsPrecessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsPrecessed = false
    }
}

class Aquarium<out T : WaterSupply>(val waterSupply: T) {
    fun addWater(clear: Clear<T>) {
        if (waterSupply.needsPrecessed) {
            clear.clear(waterSupply)
        }
        print("adding water form $waterSupply")
    }

    // inline and reified
    inline fun <reified R : WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

fun <T : WaterSupply> isWaterClear(aquarium: Aquarium<T>) {
    println("Aquarium water is clear ${aquarium.waterSupply.needsPrecessed}")
}

interface Clear<in T : WaterSupply> {
    fun clear(waterSupply: T)
}

class TapWaterCleaner : Clear<TapWater> {
    override fun clear(waterSupply: TapWater) {
        waterSupply.addChemicalsCleaners()
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("Item add")

fun genericExample() {
    val clear = TapWaterCleaner()
    val aquarium: Aquarium<TapWater> = Aquarium(TapWater())
    isWaterClear(aquarium)
//aquarium.addWater(clear)


//    val aquarium: Aquarium<TapWater> = Aquarium<TapWater>(TapWater())
//    aquarium.waterSupply.addChemicalsCleaners()
//
//    addItemTo(aquarium)
//
//
//    val aquarium4 = Aquarium(LakeWater())
//    aquarium4.waterSupply.filter()
//    aquarium4.addWater()
}

fun main(args: Array<String>) {
    genericExample()
}