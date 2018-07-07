package Pairs

class Book(val title: String, val author: String, val year: Int) {
  fun titleWithAuthor(): Pair<String, String> {
    return title to author
  }
  fun titleAuthorYear(): Triple<String, String, Int> {
    return Triple(title, author, year)
  }
}

fun main(args: Array<String>) {
  val book = Book("The Magic Faraway Tree", "Enid Blyton", 1942)
  println("book.titleWithAuthor(): ${book.titleWithAuthor()}")
  // book.titleWithAuthor(): (The Magic Faraway Tree, Enid Blyton)

  println("book.titleAuthorYear(): ${book.titleAuthorYear()}")
  // book.titleAuthorYear(): (The Magic Faraway Tree, Enid Blyton, 1942)

  val (title, author, year) = book.titleAuthorYear()

  println("Here is your book $title written by $author in $year.")

}
