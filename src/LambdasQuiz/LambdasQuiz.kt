package LambdasQuiz

enum class Directions {
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}

class Game {
    var path: MutableList<Directions> = mutableListOf(Directions.START)

    val north = { path.add(Directions.NORTH) }
    val south = { path.add(Directions.SOUTH) }
    val east = { path.add(Directions.EAST) }
    val west = { path.add(Directions.WEST) }

    val end = {
        path.add(Directions.END)
        println("Game Over")
        println("path: $path")
        path.clear()
        false
    }
}

fun main(args: Array<String>) {
    val game = Game()

    println("path: $game.path")
    // path: LambdasQuiz.Game@ea4a92b.path

    println("path: ${game.path}")
    // path: [START]

    game.north()
    game.east()
    game.south()
    game.west()
    game.end()

    println("path: ${game.path}")

    // path: []
}