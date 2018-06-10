package Spices

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}

interface SpiceColor2 {
    val color: Color
}

object YellowSpiceColor2 : SpiceColor2 {
    override val color = Color.YELLOW
}

object RedSpiceColor2 : SpiceColor2 {
    override val color = Color.RED
}

class Spice3(val color: SpiceColor2) {

}

fun main(args: Array<String>) {
    val spice3 = Spice3(color = RedSpiceColor2)
    println("spice3: ${spice3.color}")

    val spice3Color = matchColor(spice3.color)
    println("spice3Color: $spice3Color")
}

fun matchColor(color: SpiceColor2): String {
    return when (color) {
        YellowSpiceColor2 -> "yellow"
        RedSpiceColor2 -> "red"
        else -> "dunno"
    }
}