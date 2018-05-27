# Constructors

A constructor will allow us to specify the size of our aquarium when we create
it, so let's implement this.

We can pass in values in the same way as FUNCTION PARAMETERS.

And then we will assign them to the MEMBER VARIABLES.

Here we have 3 PARAMETERS

Now we will assign the constructor arguments to member variables

```kotlin
package Aquarium

class Aquarium (length: Int = 100, width: Int = 20, height: Int = 40){
    var width: Int = width
    var height: Int = height
    var length: Int = length

    var volume: Int
        get() = width * height * length / 1000
        set(value) { height = value * 1000 / ( width * length ) }

}
```

But this is not good Kotlin.

We can simplify this by declaring the variables WITH THE CONSTRUCTOR (using the
constructor)

```kotlin
package Aquarium

class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = value * 1000 / (width * length)
        }

}
```

This removes the need to assign to member variables.

Kotlin creates the member properties for us.

```kotlin
val smallAquarium = Aquarium(20, 40, 15)
```

This is really this:
```kotlin
val smallAquarium = Aquarium(length: 20, height: 40, width: 15)
```

BUT it's better to use NAMED PARAMETERS:
```kotlin
val smallAquarium = Aquarium(length = 20, width = 40, height = 15)
```

## More properties
What if we want to do more than simply assign variables inside the constructor?
For example, when we create an aquarium, the water doesn't usually fill up the
tank

```kotlin
package Aquarium

class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = value * 1000 / (width * length)
        }

    var water = volume * 0.9

}
```
The INFERRED DATA TYPE is a Double

We need to put `water` below `volume` because properties get initialized in the
order that they are defined.


## More constructors
Use the `constructor` keyword, specify the arguments, followed by a call to the
default constructor with `this()`

NB when we make an aquarium, we can't mix constructor arguments.

So we can't create an aquarium passing in the `length` and the `numberOfFish`.

The arguments have to match exactly with one of the available constructors.

```kotlin
package Aquarium

class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = value * 1000 / (width * length)
        }

    var water = volume * 0.9

    constructor(numberOfFish: Int): this()
}
```

When we make our aquarium with our 2nd constructor, the default values are taken
for the member variables:
```kotlin
    val myAquarium2 = Aquarium(numberOfFish = 9)
```

We can modify our other variables inside our constructor:
```kotlin
package Aquarium

class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = value * 1000 / (width * length)
        }

    var water = volume * 0.9

    constructor(numberOfFish: Int): this() {
        // NB. water is a different "water"
        val water = numberOfFish * 2000 // cm3
        val tank = water + water * 0.1
        height = (tank / (length * width)).toInt()
    }
}
```


## Init blocks
`init` works just like a constructor

we can use an `init` block like we use CONSTRUCTOR BODIES in other languages.

`init` blocks RUN BEFORE any secondary constructors

`init` blocks are executed in sequential order

Secondary constructors are NOT always needed.

But if we do use one, it MUST include a call to the primary constructor (by
using `this`)





## Good practice
In many other languages, defining a lot of constructors is normal.

In Kotlin, we have default parameters.

Good practice
- Use 1 constructor
- Use default parameters for optional values.
- Use init blocks
- When you need extra flexibility, consider adding helper functions

If you want to use a secondary constructor, consider using a HELPER METHOD
instead.

This keeps our classes simple
```kotlin
fun makeDefaultFish() = Fish(true, 50)
```


## Quiz: Constructor
Getting an error "Unresolved reference: spiciness"
```kotlin
class Spice(name: String, spiciness: String = "mild") {
    val heat: Int
        get() {
            return when (spiciness) { // <<<<<<<<<<<<<< here
                "mild" -> 0
                "medium" -> 5
                "hot" -> 10
                else -> 5
            }
        }
}
```

This is because we don't have ACCESS to the `spiciness` argument.

We need to assign it to a member variable:
```kotlin
class Spice(name: String, val spiciness: String = "mild") {
    val heat: Int
        get() {
            return when (spiciness) { // <<<<<<<<<<<<<< here
                "mild" -> 0
                "medium" -> 5
                "hot" -> 10
                else -> 5
            }
        }
}

fun main(args: Array<String>) {
    val spices = listOf(
            Spice(name = "nutmeg", spiciness = "mild"),
            Spice(name = "pepper", spiciness = "medium"),
            Spice(name = "curry", spiciness = "medium"),
            Spice(name = "chili", spiciness = "hot")
    )
    println("spices: $spices")

}

Spices
```
