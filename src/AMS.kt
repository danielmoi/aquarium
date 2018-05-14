import java.util.*

fun main(args: Array<String>): Unit {
    println("Hello, ${args[0]}!")
    dayOfWeek()

    val temperature = 10

    val message = "It is ${if (temperature > 30) "hot" else "not hot"} today!"
    println(message)
    feedTheFish()

//    canAddFish(10.0, currentFish = listOf(3,3,3))
//    canAddFish(8.0, listOf(2,2,2), hasDecorations = false)
//    canAddFish(9.0, listOf(1,1,3), 3)
    canAddFish(10.0, listOf(), 7, true)
}

fun canAddFish(
        tankSize: Double,
        currentFish: List<Int>,
        newFishSize: Int = 2,
        hasDecorations: Boolean = true
        ) {
    val currentFishLength = currentFish.fold(0) { acc, i -> acc + i }

    val maxLength = if (hasDecorations) {
       tankSize * 0.8
    } else tankSize

    val can = currentFishLength + newFishSize <= maxLength


    println("currentFishLength: $currentFishLength")
    println("maxLength: $maxLength")
    println("can: $can")
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")

    if (shouldChangeWater(day)) {
        println("Change the water today")
    }
}

fun randomDay(): String {
    val week = listOf<String>("Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun dayOfWeek() {
    println("What day is it today?")
    var dayNum = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when (dayNum) {
        1 -> ("Sunday!")
        2 -> ("Monday!")
        3 -> ("Tuesday!")
        4 -> ("Wednesday!")
        5 -> ("Thursday!")
        6 -> ("Friday!")
        7 -> ("Saturday!")
        else -> ("Time has stopped...")
    })
}

fun fishFood(day: String): String {
    var food = "fasting"
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitos"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun swim(speed: String = "fast") {
    println("Swimming speed: $speed")
}

fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = 22): Boolean {
    return true
}

