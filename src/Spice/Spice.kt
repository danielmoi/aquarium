package Spice

class SimpleSpice {
    var name: String = "curry"
    var spiciness: String = "mild"
    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 5
                else -> 0
            }
        }

}

fun main(args: Array<String>) {
    var spice = SimpleSpice()
    println("name: ${spice.name}")
    println("heat: ${spice.name}")
}