fun print(fortune: String) {
    println("Your fortune is: $fortune")
}


fun getBirthday(): Int {
    println("Enter your birthday day: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun main(args: Array<String>) {

    var fortune: String
    for (i in 1..10) {
        fortune = getFortune(getBirthday())
        print(fortune)
        if (fortune.contains("Take it easy")) break;
    }
}

fun getFortune(birthday: Int): String {
    val fortunes = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."
    )
    val index = birthday % fortunes.size
    return fortunes[index]
}

