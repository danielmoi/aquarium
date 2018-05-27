package Spices

abstract class Spice2(
        val name: String,
        val spiciness: String = "mild",
        color: SpiceColor) :
        SpiceColor by color {
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

    init {
        println("----------------")
        println("Spice2 constructed!")
        println("name: $name")
        println("spiciness: $spiciness")
        println("heat: $heat")
        println("----------------")
    }

    abstract fun prepareSpice()


}

class Curry(
        spiciness: String = "hot",
        color: SpiceColor = YellowSpiceColor) :
        Spice2("curry", spiciness, color),
        Grinder {
    override fun grind() {
        println("Grinding...")
    }

    override fun prepareSpice() {
        println("Preparing spice!")
    }
}

interface Grinder {
    // default implementation
    fun grind()
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor : SpiceColor {
    override val color = "yellow"
}


fun main(args: Array<String>) {
    val spices = listOf(
            Curry("hot")
    )

    val curry = spices[0]
    curry.prepareSpice()
    curry.grind()
    println("color: ${curry.color}")
}

