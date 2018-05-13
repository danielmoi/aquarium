fun main(args: Array<String>) {
    var message = "Good ${if (args[0].toInt() < 12) "morning" else "night"}, Kotlin"
    println(message)
}