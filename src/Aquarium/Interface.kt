package Aquarium

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val catfish = Plecostomus2()
    println("Fish has color ${catfish.color}")
    catfish.eat()
}

interface FishAction2 {
    fun eat()
}

interface FishColor2 {
    val color: String
}

class Plecostomus2(fishColor: FishColor2 = GoldColor()) :
        FishAction2 by PrintingFishAction("A lot of algae"),
        FishColor2 by fishColor

class GoldColor : FishColor2 {
    override val color = "gold"
}

class RedColor : FishColor2 {
    override val color = "red"
}


// takes "food" as a parameter, and implements "FishAction"
class PrintingFishAction(private val food: String) : FishAction2 {

    override fun eat() {
        println(food)
    }
}