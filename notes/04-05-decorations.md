# Decorations

Often we have classes that most act as DATA CONTAINERS

In Kotlin, for classes that mostly hold data, there is a DATA CLASS with
benefits

We create data classes by prefixing our declarations with the keyword `data`:
```kotlin
data class Decorations(val rocks) {

}
```

We can then create an instance of this class in `makeDecorations` and print all
of its properties

## Benefit 1 = printing
With a data class, printing the object will print the values of the properties,
instead of just an ADDRESS of the object (ie. the object pointer)!

Basically, it creates `toString` for us, to print the properties

```kotlin
package Aquarium.Decorations

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations(rocks = "granite")
    println("d1 rocks: ${d1.rocks}")

    val d2 = Decorations(rocks = "slate")
    println("d2: ${d2}")

    val d3 = Decorations(rocks = "slate")
    println("d3: ${d3}")
}

data class Decorations(val rocks: String, val rockCount: Number = 10) {

}

/*
d1 rocks: granite
d2: Decorations(rocks=slate, rockCount=10)
d3: Decorations(rocks=slate, rockCount=10)

Process finished with exit code 0
*/
```


## Benefit 2 = comparison
The data class provides an equals method to compare 2 instances of a data class

```kotlin
fun makeDecorations() {
  println(d2.equals(d3))
  println(d2 == d3)
}
// true
// true
```


## Copy
We can copy data objects using the `copy` method.
```kotlin
val d3copy = d3.copy()
```

This creates a new object with the same property values.


## Decomposition
To get properties, and assign them to variables, Kotlin lets us use a process
called decomposition.
```kotlin
val ( rock, wood, diver ) = d5;
```
Note:
- use parentheses, not curly braces
- the number of variables must match the number of properties, else we get an
  error
- the variables are assigned in the order in which they are declared in the class...
