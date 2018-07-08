package Constants

const val MAX_BORROWED_BOOKS = 10

class Book(val title: String) {
  companion object {
      const val BASE_URL = "https://library.com"
  }
  fun canBorrow(user: User): Boolean {
    return user.booksBorrowed < MAX_BORROWED_BOOKS
  }
  fun printUrl(): String {
    return "$BASE_URL/$title.html"
  }
}

class User {
  var booksBorrowed: Int = 0

  fun borrowBook() {
    booksBorrowed += 1
  }

  fun returnBook() {
    booksBorrowed -= 0
  }
}

fun main(args: Array<String>) {
  val user = User()
  user.borrowBook()

  val book1 = Book("1Q84")
  val canBorrow = book1.canBorrow(user)
  println("canBorrow: ${canBorrow}")

  println("book1.printUrl(): ${book1.printUrl()}")
}
