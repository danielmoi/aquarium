package Collections

fun main(args: Array<String>) {
  val symptoms = mutableListOf("white spots", "red spots", "not eating", "belly up")

  symptoms.add("white fungus")
  symptoms.remove("red spots")

  println("symptoms: ${symptoms}")
  // symptoms: [white spots, not eating, belly up, white fungus]


  val hasWhiteSpots = symptoms.contains("white spots")
  println("hasWhiteSpots: ${hasWhiteSpots}")

  val sublist = symptoms.subList(fromIndex = 1, toIndex = 3)
  println("sublist: ${sublist}")
  // [not eating, belly up]


  val sum = symptoms.sumBy { it.length }
  println("sum: ${sum}")
  // 41

  val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")
  println("cures: ${cures}")
  // cures: {white spots=Ich, red sores=hole disease}

  println(cures.get("white spots"))
  println(cures["white spots"])

  println(cures.getOrDefault("NUP", "It's all ok"))

  println(cures.getOrElse("white nup", { "Executing this function!" }))
}
