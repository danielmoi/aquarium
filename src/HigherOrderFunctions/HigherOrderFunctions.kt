package HigherOrderFunctions

data class Fish (var name: String)

fun main(args: Array<String>) {
    fishExamples()
}

fun fishExamples() {
    val fish = Fish("splashy")

    println("fish: $fish")

    // "capitalize" is our BLOCK FUNCTION
    with(fish.name) {
        this.capitalize()
    }
    println("fish: $fish")

    myWithExample()
}

fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun myWithExample() {
    val fish = Fish("hello")

    myWith(fish.name) {
        print(capitalize())
    }

    fish.run { name }
    /*
        this is the same as:
        fish.fun {
          this.name
        }

        we are just returning the name
     */

    fish.apply{}
    /*
        we return the fish object
     */

    val fish2 = Fish("splashy").apply{ name }
    println("fish2: ${fish2.name}")
    // splashy

    // let's apply a lambda to set its name
    val fish3 = Fish("splashy").apply{ name = "New New" }
    println("fish3: ${fish3.name}")
    // New New

    val x = fish.let{ it.name.capitalize() }
            .let{ it + "fish" }
            .let{ it.length }
            .let{ it + 31 }
    println("fish: $fish")
    // hello

    println("x: $x")
    // 40

}
