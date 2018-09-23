package SAM

interface Runnable {
    fun run()
}
interface Callable<T> {
    fun call(): T
}

// let's call runNow
fun example() {
    // make an object of Runnable, and implement the "run" method
    // this syntax "object" let's us instantiate an object that implements an interface
    // object: Class
    // it's useful for passing parameters like this
    val runnable = object: Runnable {
        override fun run() {
            println("Running!!!!!!")
        }
    }
    // a lot of code just to call println!!
    JavaRun.runNow(runnable)
}


// In Kotlin, we can pass a lambda instead of a SAM
// Kotlin will take care of making the right kind of object for us!
fun example1() {
    JavaRun.runNow {
        println("Passing a lambda as a runnable!")
    }
}

// Even cooler, if you take the SAM as the last parameter like we do here
// You can use the last parameter call syntax to specify the lambda outside of the prints