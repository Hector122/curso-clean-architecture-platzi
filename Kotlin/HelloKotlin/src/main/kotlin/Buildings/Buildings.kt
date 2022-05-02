package Buildings

open class BaseBuildingMaterial {
    open val numberNeeded = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded = 8
}

class Building<out T : BaseBuildingMaterial>(val buildingMaterial: T) {
    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = baseMaterialsNeeded * buildingMaterial.numberNeeded

    fun build(): Unit {
        println("$actualMaterialsNeeded  ${buildingMaterial::class.simpleName} required")
    }
}

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    println(if (building.actualMaterialsNeeded < 500) "small building" else "lage building")
}

fun main() {
    val building = Building(Brick())
    building.build()

    isSmallBuilding(building)
}