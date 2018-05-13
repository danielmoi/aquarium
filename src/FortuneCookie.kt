fun print(fortune: String) {
    println("Your fortune is: $fortune")
}
fun getAndPrint() {
    val fortune = getFortuneCookie()
    print(fortune)

}

fun main(args: Array<String>) {

    var count = 10
    do {
        println("Enter your birthday: ")
        getAndPrint()
        count -= 1
    } while (count > 0)
}

fun getFortuneCookie(): String {
    val fortunes = listOf(
            "You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune."

    )
    val birthday: Int = readLine()?.toIntOrNull() ?: 1
    val index = birthday % fortunes.size
    return fortunes[index]
}