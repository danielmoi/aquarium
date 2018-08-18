package Aquarium.generics

/*
- an open class, so we can subclass from it
- it has a "var" parameter "needsProcessed", which is a boolean
- this parameter automatically creates
    - a mutable (var) property on WaterSupply called needsProcessed
    - a getter
    - a setter
- this parameter is public by default, and so is available to child classes

- the subclass TapWater EXTENDS WaterSupply
*/
open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners() {
        // after we clean the water, we don't need to process the water anymore (it's been cleaned)
        needsProcessed = false
    }
}

// another subclass
// doesn't need cleaning, so we pass "false" to the WaterSupply CONSTRUCTOR
class FishStoreWater : WaterSupply(false) {

}

// another subclass
class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }

}

// Now that we have some types, let's make a generic Aquarium!
// we pronounce generic types as "type T"
// ie. "type" followed by the name of the generic.

// let's add an IMMUTABLE property WaterSupply of type T to Aquarium
class Aquarium<T> (val waterSupply: T) {

}

// Now, we can make a new Aquarium, and pass it a water supply!
fun genericExample() {
    // we instantiate Aquarium
    // Add angle brackets with the type right after the class name
    // then, like normal parentheses, the class of tap water (that we ALSO need to INSTANTIATE)
    // so, we pass a TapWater INSTANCE as the value for the WaterSupply parameter
    val aquarium = Aquarium<TapWater>(TapWater())

    // Now, we can access WaterSupply, and because IT is a of type TapWater,
    // we can call addChemicalCleaners
    // WITHOUT doing any CASTS!


    aquarium.waterSupply.addChemicalCleaners()
    // not like this:
    // aquarium.addChemicalCleaners()

}

// Kotlin does have type inference, so there's not reason to say TapWater twice,
// when we create the instance
// the type can be inferred by the arguments to Aquarium!
fun cleanerExample() {
    val aquarium = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

}


// Now let's pass a STRING into our Aquarium class
fun oops() {
    val aquarium = Aquarium("HELLO")
    println("waterSupply ${aquarium.waterSupply}")
    // HELLO
}

// Why did that work?
// This is because type T doesn't have any BOUNDS.
// So, it can actually be set to ANY TYPE.


// Similarly, we can pass in nulls, and this also works
fun nullExample() {
    val aquarium = Aquarium(null)
    println("waterSupply ${aquarium.waterSupply}")
    // null
}
// Why is Kotlin allowing us to pass in "null"?
// We've made water supply to be of "type T", and not "T question mark"...
// Well, it turns out, by default, "T" stands for the nullable "ANY TYPE"
// "ANY" is at the top of the "type hierarchy"

// This is the longhand
// class Aquarium<T: Any?>(val waterSupply: T)

// To ensure that our parameter is non-null, but can still be any type,
// we remove the "?"
// class Aquarium<T: Any>(val waterSupply: T)


// We can be as specific as we want with the GENERIC CONSTRAINT
// We can replace "Any" with any type we want
// class Aquarium<T: WaterSupply>(val waterSupply: T)

class Aquarium2<T: WaterSupply>(val waterSupply: T) {
    fun addWater() {
        // "check" is a standard library function in Kotlin
        // it's really convenient for checking the state of your classes
        // it acts as an ASSERTION and will throw an "illegal exception" if it is false
        // else, go on to the next statement
        // we don't need parentheses, because the dot (".") has precedence over the "!"
        check(!waterSupply.needsProcessed) { "Water supply needs processing" }
        println("Adding water from $waterSupply")
        // NB. we can always access "needsProcessed" on waterSupply, because T has a
        // "generic constraint" of WaterSupply

        /*
        Exception in thread "main" java.lang.IllegalStateException: Water supply needs processing
        waterSupply null
            at Aquarium.generics.Aquarium2.addWater(Aquarium.kt:117)
            at Aquarium.generics.AquariumKt.checkExamples(Aquarium.kt:126)
            at Aquarium.generics.AquariumKt.main(Aquarium.kt:135)

        Process finished with exit code 1
         */
    }
}




fun checkExamples() {
    val aquarium = Aquarium2(LakeWater())
    aquarium.addWater()
}

// OUT TYPES
class AquariumOutType<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed) {
            println("Adding water from ${waterSupply::class.simpleName}")
            cleaner.clean(waterSupply)
        }
    }
}
// Kotlin can ensure that addItemTo won't do anything unsafe with a generic
fun addItemTo(aquarium: AquariumOutType<WaterSupply>) = println("item added")


fun outExample() {
    // val aquarium = Aquarium2(TapWater())
    // addItemTo(aquarium)
    // the compiler gives us an error
    // Error:(154, 15) Kotlin: Type mismatch: inferred type is Aquarium2<TapWater>
    // but Aquarium2<WaterSupply> was expected

    val aquariumOutType = AquariumOutType(TapWater())
    addItemTo(aquariumOutType)
}

// IN TYPES
interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}
class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}
fun inExample() {
    val cleaner = TapWaterCleaner()
    val aquarium = AquariumOutType(TapWater())
    aquarium.addWater(cleaner)
}

fun main(args: Array<String>) {
//    oops()
//    nullExample()
//
//    checkExamples()
    outExample()

    inExample()
}