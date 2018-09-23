package Inline

// A function called "move"
// Takes an argument called "where", which is a LAMBDA
// The lambda takes no arguments, and returns Unit
fun move(where: () -> Boolean) {
    // invoke the passed-in lambda
    // This returns a Boolean????
    where.invoke()
}

enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game {
    // This initializes our path with a single element, "START"
    // mutable, because we will add to this
    var path: MutableList<Directions> = mutableListOf(Directions.START)

    // these 4 are lambda functions, adding a Direction to our path
    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }

    // this function is another lambda, adding END to our path
    // then clears the path...
    val end = {
        path.add(Directions.END)
        println("Game Over")
        println("path: $path")
        path.clear()
        // the return of this function is now a Boolean
        false
    }


    fun makeMove(command: String?): Unit {
        // test whether the string is any of the 4 directions and invoke
        // move with the corresponding lambda
        // otherwise, invoke move with end
        if (command.equals("n")) move(north)
        else if (command.equals("s")) move(south)
        else if (command.equals("w")) move(west)
        else if (command.equals("e")) move(east)
        else move(end)

        println("Current path: $path")
    }
}

fun main(args: Array<String>) {
    val game = Game()

    while (game.path.size > 0) {
        print("Enter a direction: n/s/e/w: ")
        val move = readLine()
        game.makeMove(move)
    }

    println("GAME OVER!")
}