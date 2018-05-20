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





