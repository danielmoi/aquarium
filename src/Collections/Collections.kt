package Collections

fun main(args: Array<String>) {
  val testList: List<Int>  = listOf(11,12,13,14,15,16,17,18,19)

  val result = reverse(testList)
  println("result: ${result}")

  println("reverseListAgain(testList): ${reverseListAgain(testList)}")
}

fun reverse(list: List<Int>): List<Int> {
  val result = mutableListOf<Int>()
  for (i in 0 .. list.size-1) {
    result.add(list[list.size-i-1])
  }
  return result
}

fun reverseListAgain(list: List<Int>): List<Int> {
  val result = mutableListOf<Int>()
  for (i in list.size - 1 downTo 0) {
    result.add(list[i])
    // or, result.get(list[i])
  }
  return result
}



