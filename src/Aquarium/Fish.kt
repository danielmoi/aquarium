package Aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {
    // no variable will be created for volumeNeeded

    val size: Int

    init {
        println("FIRST init block")
    }

    // secondary constructor
    constructor() : this(true, 9) {
        println("SECONDARY CONSTRUCTOR")
    }

    init {
        println("SECOND init block")
        if (friendly) {
            size = volumeNeeded
        } else {
            size = volumeNeeded * 2
        }
    }

    init {
        println("THIRD init block")
        println("Constructed fish of size ${volumeNeeded} " +
                "finalSize: ${this.size}")
    }
}

fun makeDefaultFish() = Fish(true, 50)


fun fishExample() {
    val fish = Fish(friendly = true, volumeNeeded = 20)
    println("Friendly: ${fish.friendly}")
    println("Volume needed: ${fish.size}")
    /*
        FIRST init block
        SECOND init block
        THIRD init block
        Friendly: true
        Volume needed: 20
    */


    val fish2 = Fish()
    println("Friendly: ${fish2.friendly}")
    println("Volume needed: ${fish2.size}")
    /*
        FIRST init block
        SECOND init block
        THIRD init block
        SECONDARY CONSTRUCTOR
        Friendly: true
        Volume needed: 9
     */

}

fun main(args: Array<String>) {
    fishExample()
}