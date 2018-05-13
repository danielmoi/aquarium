import java.util.*

fun main(args: Array<String>): Unit {
    println("Hello, ${args[0]}!")
    dayOfWeek()

    val temperature = 10

    val message = "It is ${if (temperature > 30) "hot" else "not hot"} today!"
    println(message)
}

fun feedTheFish() {
    
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