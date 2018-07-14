package ExtensionFunctions

fun String.hasSpaces(): Boolean {
  val found: Char? = this.find { it == ' ' }
  return found != null
}

fun extensionsExample(): Boolean {
  return "Does it have spaces?".hasSpaces()
}

fun String.shorterHasSpaces() = find { it == ' '}

fun main(args: Array<String>) {
  val answer = extensionsExample()
  println("answer: ${answer}")
  // true

  staticExample()
}

// need to make this class "open", instead of "final", so that it can
// be inherited from...
open class AquariumPlant(val color: String, private val size: Int) {

}

fun AquariumPlant.isRed() = color == "Red"
fun AquariumPlant.print() = println("AquariumPlant")



class GreenLeafyPlant(size: Int): AquariumPlant("Green", size)
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample() {
  val plant = AquariumPlant("Red", 10)
  println("plant.isRed(): ${plant.isRed()}")
  // true
  plant.print()

  val greenPlant = GreenLeafyPlant(100)
  println("greenPlant.isRed(): ${greenPlant.isRed()}")
  greenPlant.print()

  val magic: AquariumPlant = plant
  magic.print()
  // AquariumPlant
  // this is because the extension function is RESOLVED statically
  // ie. at compile time
  // And the compiler just looks at the TYPE of the VARIABLE
}
