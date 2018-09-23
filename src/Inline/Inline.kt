package Inline

// takes a string name
// and an extension Lambda (of the type signature String -> Unit)
// in the BODY, it applies the extension lambda to the name
fun myWith(name: String, block: String.() -> Unit) {
   name.block()
}

data class Fish(val name: String)

fun fishExamples() {
    val fish = Fish("Splashy")

    // now let's "call myWith on fish.name"
    myWith(fish.name) {
        capitalize()
    }

    myWith(fish.name, block = {
        capitalize()
    })

    // Kotlin is saying that the lambda argument should be moved OUT
    // of the parentheses (?!)
    myWith(fish.name, {
        capitalize()
    })

    // there's one problem with this.
    // Everytime we call "myWith", Kotlin will make a NEW lambda object
    // Yes, Lambdas are objects
    // a lambda expression is an instance of a function interface,
    // which is, itself, a subtype of object

    // let's write it out longhand like this:
    // create an instance of function1 every time myWith is called
    // takes CPU time and memory
    // usually not an issue, but the overhead (resources) may add up
    myWith(fish.name, object: Function1<String, Unit> {
        override fun invoke(name: String) {
            name.capitalize()
        }
    })

    // to fix this, Kotlin allows us to define "myWith" as INLINE
    // that is, a PROMISE, that every time myWith is called, it
    // will transform the source code to inline, the function
    // that is, the compiler will change the code to replace the lambda
    // with the instructions inside the Lambda
    // this means zero overhead

    // with inline, no object is created, and lambda body is inlined here
    fish.name.capitalize()
}

inline fun myInlineWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun main(args: Array<String>) {
    fishExamples()
}