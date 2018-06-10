package Aquarium.Decorations

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations(rocks = "granite")
    println("d1 rocks: ${d1.rocks}")

    val d2 = Decorations(rocks = "slate")
    println("d2: ${d2}")

    val d3 = Decorations(rocks = "slate")
    println("d3: ${d3}")

    println("d1 equal d2: ${d1 == (d2)}")
    println(d2.equals(d3))

    val d3copy = d3.copy()
    print(d3copy)

    val d5 = Decorations2("crystal", "wood", "diver")

    val ( rock, wood, diver ) = d5;
    println(rock)
    println(wood)
    println(diver)
}

data class Decorations(val rocks: String, val rockCount: Number = 10) {

}

data class Decorations2(val rocks: String, val wood: String, val diver: String) {

}
