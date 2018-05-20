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

    val smallAquarium = Aquarium(length = 20, width = 40, height = 15)
    println("Volume: ${smallAquarium.volume}")


    println("----------------")
    val myAquarium2 = Aquarium(numberOfFish = 9)
    println("Volume: ${myAquarium2.volume} liters")
    println("Length: ${myAquarium2.length}")
    println("Height: ${myAquarium2.height}")
    println("Width: ${myAquarium2.width}")


}