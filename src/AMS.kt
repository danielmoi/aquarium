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

    val magic = currentFish.fold(0) { acc, i -> acc + i } + newFishSize <= if (hasDecorations) {
        tankSize * 0.8
    } else tankSize


    println("currentFishLength: $currentFishLength")
    println("maxLength: $maxLength")
    println("can: $can")
    println("m")
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
        "Wednesday" -> "worms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun swim(speed: String = "fast") {
    println("Swimming speed: $speed")
}

fun getDirtySensorReading() = 20

fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = getDirtySensorReading()): Boolean {

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false

    }
}

var dirty = 20
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
}

fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"

