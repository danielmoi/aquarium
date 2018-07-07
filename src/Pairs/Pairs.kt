package Pairs

fun main(args: Array<String>) {
  val equipment = "fishnet" to "catching fish"
  println("equipment: ${equipment}")
  // equipment: (fishnet, catching fish)
  println("equipment.first: ${equipment.first}")
  // equipment.first: fishnet

  val chained = "first" to "second" to "third"
  println("chained: ${chained}")
  // chained: ((first, second), third)
  println("chained.first: ${chained.first}")
  // chained.first: (first, second)
  println("chained.first.first: ${chained.first.first}")
  // chained.first.first: first
  println("chained.first.second: ${chained.first.second}")
  // chained.first.second: second
  println("chained.second: ${chained.second}")
  // chained.second: third

  val letKotlin = "A" to "B" to "C" to "D"
  println("letKotlin: ${letKotlin}")
  // letKotlin: (((A, B), C), D)

  val letMe = ("A" to "B") to ("C" to "D")
  println("letMe: ${letMe}")
  // letMe: ((A, B), (C, D))

  val data = "suburb" to "Sydney"
  val (key, value) = data
  println("key: ${key}")
  println("value: ${value}")
  // key: suburb
  // value: Sydney

  val (tool, use) = giveMeATool()
  println("tool: ${tool}")
  println("use: ${use}")
}

fun giveMeATool(): Pair<String, String> {
  return ("fishnet" to "catching")
}
