package Spice

class Spice(val name: String, val spiciness: String = "mild") {
    val heat: Int
        get() {
            return when (spiciness) {
                "zero" -> 0
                "mild" -> 1
                "medium" -> 5
                "hot" -> 10
                else -> 5
            }
        }

    constructor(): this() {
        makeSalt()
    }

    init {
        println("----------------")
        println("Spice constructed!")
        println("name: $name")
        println("spiciness: $spiciness")
        println("heat: $heat")
        println("----------------")
    }


}

fun main(args: Array<String>) {
    val spices = listOf(
            Spice(name = "nutmeg", spiciness = "mild"),
            Spice(name = "pepper", spiciness = "medium"),
            Spice(name = "curry", spiciness = "medium"),
            Spice(),
            Spice(name = "chili", spiciness = "hot")
    )
    println("spices: ${spices.map { it.name }}")

    val spicySpices = spices.filter { it.heat > 5 }
    println("spicySpices: ${spicySpices.map { it.name }}")

    val mildSpices = spices.filter { it.heat <= 5 }
    println("mildSpices: ${mildSpices.map { it.name }}")


}

fun makeSalt() = Spice("salt", "zero")