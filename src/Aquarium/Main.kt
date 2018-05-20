package Aquarium

fun main(args: Array<String>) {
    buildAquarium()

}

fun buildAquarium() {
    val myAquarium = Aquarium()

    println("Length: ${myAquarium.length}")
    println("Width: ${myAquarium.width}")
    println("Height: ${myAquarium.height}")
    println("Volume: ${myAquarium.volume}")

    myAquarium.height = 80
    println("Height: ${myAquarium.height}")

    println("Volume: ${myAquarium.volume}")

}