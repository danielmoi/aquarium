package LambdasRecap

fun main(args: Array<String>) {
    data class Fish (val name: String)

    val myFish = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))

    val withLetter = myFish.filter { it.name.contains("i")}

    println("withLetter: $withLetter")
    // [Fish(name=Flipper), Fish(name=Moby Dick)]

    println("withLetter: ${withLetter.joinToString(", "){ it.name }}")
    // Flipper, Moby Dick
}