package HigherOrderFunctions

/*
    This an extension function on List
    Takes a lambda on Int, and applies it to each item in the list

    - the extension function is called "divisibleBy"
    - it takes one argument, a function "block"
        - block has the type signature Int -> Int
    - the return type of our extension function is a List<Int>
 */
fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    // this is the function body of our extension function
    val result = mutableListOf<Int>()

    // We iterate over each item in the list here
    for (item in this) {
        // we call the function "block" with each successive item
        if (block(item) == 0) {
            // ie. the return result from the lambda equals zero
            result.add(item)
        }
    }
    return result
}

fun main(args: Array<String>) {
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)

    val result = numbers.divisibleBy {
        // this is our "block" function
        // our "block" lambda
        // remember Int -> Int
        // "it" is our first Int
        // the result of the expression it.div(3) is our next Int

        // it.div(3)
        // 1.div(3) == 0
        // so using this will return [0, 1, 2]

        // "rem" is modulo = the remainder
        it.rem(3)
        // [3, 6, 9, 0]
    }

    println(result);
}