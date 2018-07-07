package Collections

fun main(args: Array<String>) {
  // SETS
  val allBooks = setOf<String>("Hamlet", "Romeo and Juliet")

  val library = mapOf(Pair("Shakespeare", allBooks))

  val hasHamlet = library.any { it.value.contains("Hamlet") }
  println("hasHamlet: ${hasHamlet}")

  // MAPS
  val moreBooks = mutableMapOf(Pair("Hamlet", "William Shakespeare"))

  val one = moreBooks.getOrPut("Hamlet", { "William Shakespeare" })
  val two = moreBooks.getOrPut("1Q84", { "Haruki Murakami" })
  println("one: ${one}")
  // one: William Shakespeare
  println("two: ${two}")
  // two: Haruki Murakami
  println("moreBooks: ${moreBooks}")
  // moreBooks: {Hamlet=William Shakespeare, 1Q84=Haruki Murakami}
}
