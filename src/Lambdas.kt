import java.util.*

val rollDice = { sides: Int ->
    if (sides == 0) 0
    Random().nextInt(12)
}


val rollDice2: (sides: Int) -> Int = { sides ->
    if (sides == 0) 0
    Random().nextInt(12)
}

fun gamePlay(rollDice: (Int) -> Int) {
    println(rollDice(1))
}

