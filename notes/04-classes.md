# Classes

Object Oriented Programming in Kotlin

A refresher so we are using the same terminology.


Class = Object Blueprint (Aquarium Plan)

Object = Instance of a Class (Actual Aquarium)

Property = Class Characteristic (Aquarium height, width)

Method = Class Function (fillWithWater())
- functions belonging to a class
- what an object can do

Interface = Specification a Class can implement (Clean)
- cleaning is not specific to aquariums
- cleaning can happen in a general sense
- we can have an Interface "Clean", and Aquarium COULD implement it

## Defining classes for our Aquarium

Let's create a new package.

This is not always required, but it's good to keep our classes organised into
packages.

src > New Package > Aquarium

src > New File/Class > Aquarium.kt

This gives us this:
```kotlin
package Aquarium

class Aquarium
```

This is a valid class, but it doesn't HAVE anything, nor can it DO anything.

Let's define some properties


```kotlin
package Aquarium

class Aquarium {
    val width: Int = 20
    val height: Int = 40
    val length: Int = 100
}
```
We are setting them in the class, and they are `val`, so they are immutable.


## Instance
Now let's create an instance

Let's create a file for our `main` and the other functions that are now methods
(inside our class)

src > New File/Class > Main.kt


We can have more than one `main` function, and we can choose which one to run by
right-click and choosing RUN.

The shortcut for this is CTRL+SHIFT+R

NB: This will run `Aquarium.MainKt` - and we can do this from inside any function!


Now let's invoke a function `buildAquarium` which will give an error until we
define / implement the function.

```kotlin
package Aquarium

fun main(args: Array<String>) {
    buildAquarium()

}

fun buildAquarium() {
    val myAquarium = Aquarium()
}
```

We call our class like a function.  This does what the `new` keyword does in
other languages.

It creates a new instance of our class, by calling its CONSTRUCTOR.

Constructors create object instances from Class descriptions.

## Properties
Note that we can access the properties directly.


```kotlin
package Aquarium

fun main(args: Array<String>) {
    buildAquarium()

}

fun buildAquarium() {
    val myAquarium = Aquarium()

    println("Length: ${myAquarium.length}")
    println("Width: ${myAquarium.width}")
    println("Height: ${myAquarium.height}")
}
```

Under the hood, Kotlin actually made GETTERS for all 3 properties.

When we access properties, Kotlin always calls the corresponding GETTER, even
though it looks like we are accessing the property directly.



## Mutable Properties
Now let's allow our properties to be mutated.


```kotlin
package Aquarium

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100
}
```

```kotlin
fun buildAquarium() {
    val myAquarium = Aquarium()

    println("Length: ${myAquarium.length}")
    println("Width: ${myAquarium.width}")
    println("Height: ${myAquarium.height}")

    myAquarium.height = 80
    println("Height: ${myAquarium.height}")
}

```

NB: we do not have to change `myAquarium` to be mutable.

This is because we are NOT changing `myAquarium`.

It's the SAME OBJECT. We are simply modifying its PROPERTIES.


## Volume
Let's create a function to calculate the volume of our aquarium.
```kotlin
package Aquarium

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    fun volume(): Int {
        return width * height * length / 1000
    }
}
```


We can make it a one-liner:
```kotlin
package Aquarium

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    fun volume(): Int = width * height * length / 1000
}
```

However, `volume` just returns a VALUE.

Whether it is a property or a function does not matter to the consumer.

It is better represented as a PROPERTY.

This property has a default GETTER that returns its VALUE.

We can override the default getter.

```kotlin
package Aquarium

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    val volume: Int
        get() {
           return width * height * length / 1000
        }
}
```

We can one-line this again:
```kotlin
package Aquarium

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    val volume: Int
        get() = width * height * length / 1000

}
```


## Setter
By convention, the name of the SETTER PARAMETER is VALUE (but we can choose a
different name if we prefer)

When we change the volume, at least one dimension of our aquarium has to change.

ie. because volume is a computer property, we don't change the volume per se,
we change one of the dimensions.

Let's just change the height.

```kotlin
package Aquarium

class Aquarium {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    var volume: Int
        get() = width * height * length / 1000
        set(value) { height = value * 1000 / { width * length } }

}
```

If we don't want anyone outside of the CLASS to access that SETTER, we can make
it private.

ie. only methods inside our Aquarium class will be able to use that setter.
```kotlin
private set(value) { height = value * 1000 / { width * length } }
```


## Visibility modifiers
So far, we have not used any visibility declarations

In Kotlin, everything is PUBLIC by default.

This means that all of our variables and classes can be accessed everywhere.

Even the MEMBER VARIABLES of an object.

However, there ARE visibility modifiers in Kotlin.

We can use them to limit the size of the API that we expose.


```
public = Default. Everywhere

private = File
- only visible inside the file that contains the declaration
- seeing as we are only going to use `buildAquarium` inside our Aquarium file,
  we can make it private

internal = Module
- visible anywhere in the same MODULE
```


## Module
A module is a set of Kotlin files tied together.

We can use a function marked as `internal` inside our module, but it wouldn't be
EXPORTED as a function.

## Class Visibility
Members INSIDE a CLASS

```
public = Default
- Class and public members

private - Inside class.
- subclasses can't see

protected - inside class
- subclasses CAN see

internal - Module
```

## Spice Quiz
Spices are better represented as OBJECTS rather than simple strings.

Let's make a simple `Spice` class.

NB: `main` + ENTER will create this snippet!
```kotlin
fun main(args: Array<String>) {

}
```

```kotlin
package Spice

class SimpleSpice {
    var name: String = "curry"
    var spiciness: String = "mild"
    val heat: Int
        get() {
            return when (spiciness) {
                "mild" -> 5
                else -> 0
            }
        }

}

fun main(args: Array<String>) {
    var spice = SimpleSpice()
    println("name: $spice.name")
    println("heat: $spice.heat")
}
```

That printed this:
```
name: Spice.SimpleSpice@34340fab.name
heat: Spice.SimpleSpice@34340fab.heat
```


That was because i needed to EVALUATE the EXPRESSIONS in my print statements
```kotlin
fun main(args: Array<String>) {
    var spice = SimpleSpice()
    println("name: ${spice.name}")
    println("heat: ${spice.name}")
}
```
