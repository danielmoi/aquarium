package Generics

open class BaseBuildingMaterial(var numberNeeded: Int = 1)

class Wood : BaseBuildingMaterial(numberNeeded = 4)
class Brick : BaseBuildingMaterial(numberNeeded = 8)

class Building<T : BaseBuildingMaterial>(val buildingMaterial: T) {
    val baseMaterialsNeeded = 100

    val actualMaterialsNeeded = baseMaterialsNeeded * buildingMaterial.numberNeeded

    fun build() {
        println("$actualMaterialsNeeded ${buildingMaterial::class.simpleName} needed")
    }
}


fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("small building")
    else println("large building")
}

fun main(args: Array<String>) {
    val building = Building(Wood())
    building.build()
    isSmallBuilding(building)
}