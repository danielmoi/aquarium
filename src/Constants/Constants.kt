package Constants

const val rocks = 3

val number = 3

fun complexFunctionCall() {}

val result = complexFunctionCall()

// const val result2 = complexFunctionCall()
// const `val` has type 'Unit'. Only String and primitives allowed.

const val CONSTANT = "top-level constant"

object Constants {
  const val CONSTANT2 = "object constant"
}

fun main(args: Array<String>) {
  println("CONSTANT: ${CONSTANT}")
  // CONSTANT: top-level constant

  // CONSTANT2 is out of scope
  // println("CONSTANT2: ${CONSTANT2}")
}

class MyClass {
  companion object {
      const val GREETING = "HELLO"
  }
}
