package ExtensionProperties

class AquariumPlant(val color: String)

// Error:(5, 31) Kotlin: Extension property cannot be initialized because it has no backing field
// val AquariumPlant.shortName = "aq-plant"

val AquariumPlant.isGreen: Boolean
  get() = color == "Green"


fun main(args: Array<String>) {
  val plant = AquariumPlant("Red")

  println("plant.isGreen: ${plant.isGreen}")
  // false

  plant.pull()
  // removing ExtensionProperties.AquariumPlant@34340fab
}

// if we omit the "?" after AquariumPlant,
fun AquariumPlant?.pull() {
  // we get this error for "this":
  // unnecessary safe call on a non-null receivable of type AquariumPlant
  // However, when we do add "?", here, in the BODY of the FUNCTION,
  // we are testing for null by using ?.apply
  this?.apply {
    println("removing ${this}")
  }
}


fun nullableExample() {
  val plant: AquariumPlant? = null
  plant.pull()
}
