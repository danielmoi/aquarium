fun main(args: Array<String>) {
    val mood = getMood()
    val activity = whatShouldIDoToday(mood)
    println(activity)
}

fun getMood(): String {
    println("What's your mood?")
    return readLine() ?: ""
}

fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24): String {
    return when {
        stayInBed(mood, weather, temperature) -> "Stay in bed"
        goSwimming(mood, weather, temperature) -> "Go swimming"
        mood == "happy" && weather == "Sunny" -> "Go for a walk"
        else -> "Stay home and read"
    }
}

fun stayInBed(mood: String, weather: String, temperature: Int): Boolean {
    return mood == "sad" && weather == "rainy" && temperature == 0
}

fun goSwimming(mood: String, weather: String, temperature: Int): Boolean {
    return temperature > 35
}

