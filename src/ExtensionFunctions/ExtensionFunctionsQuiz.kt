package ExtensionFunctions

import java.util.*

class Book(val name: String, var pages: Int)

fun Book.weight() = pages * 1.5
fun Book.tornPages(torn: Int) {
  if (pages >= torn) pages -= torn
  else pages = 0
}

fun main(args: Array<String>) {
  val book = Book("Magic Faraway Tree", 100)
  println("book.weight(): ${book.weight()}")
  // 150.0

  book.tornPages(10)
  println("book.weight(): ${book.weight()}")
  // 135.0

  val puppy = Puppy()
  while (book.pages > 0) {
    puppy.playWithBook(book)
  }
}


class Puppy {
  fun playWithBook(book: Book) {
    println("book.pages: ${book.pages}") 
    val torn = (Math.random() * 10).toInt()
    println("torn: ${torn}")
    // 5
    book.tornPages(torn)
    println("book.weight(): ${book.weight()}")
    // 127.5

  }
}
