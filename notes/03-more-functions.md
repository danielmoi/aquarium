# More functions

## Filters
Filters are another control flow construct that you can use from the
standard library

Let's use a filter to pick some aquarium decorations.

```kotlin
val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
println(decorations.filter { true })

println(decorations.filter { it[0] == 'p' })
println(decorations.filter { it.startsWith("p") })
```

Filter tests every item in a list against its condition, and return a boolean

Inside the filter, is the code that does the filtering

The code is in curly braces because we are evaluating an expression for every
element in decorations

`it` refers to each element in the list

In Kotlin, SINGLE QUOTES indicate CHARACTERS
and double quotes, for STRINGS


## Eager / Lazy
Fitler is both
By default, on a list, filter is EAGER.

This means that every time you call filter, it creates a new list with the
elements that pass through the filter
```kotlin
fun eagerExample() {
  val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

  val eager = decorations.filter { it[0] == 'p' }
  println(eager)
  // [pagoda, plastic plant]

  // 1. apply filter lazily
  val filtered = decorations.asSequence().filter { it[0] == 'p' }
  println(filtered)
  // kotlin.sequences.FilteringSequence@1bb3e150

  println(filtered.toList())
  // [pagoda, plastic plant]


  // 2. apply map lazily
  val lazyMap = decorations.asSequence().map {
    println("it: $it")
  }
  // because it's lazy, nothing prints

  // but when we try to access elements, THEN our filter will run
  println("first: ${lazyMap.first()}")
  // it: rock
  // first: kotlin.Unit

  // now let's access the whole list, the filter is run against all elements
  println("all: ${lazyMap.toList()}")

}
eagerExample()
```

If you want LAZY behaviour, you can use SEQUENCES

A sequence is a collection that can only look at one item at a time, starting at
the beginning and going to the end.

Conveniently, this is exactly the API that `filter` needs

When you return the filter results as a sequence, our filtered variable won't
hold a new list, it will hold a sequence of all of the list items, and knowledge
of the filter applied to its elements

Whenever you access elements of the sequence, the filter is applied, and the
results are returned.

If we want to turn it back to a list, we can call `.toList()`.

At this point, our filter will be run, and all of our elements will be put in
the new list.



## Filter Quiz
```kotlin
val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

val sorted1 = spices.filter{ it.contains("curry").sortedBy { it.length }}
val sorted2 = spices.sorted()

val withCE1 = spices.filter { it[0] == 'c' && it.endsWith('e') }
val withCE2 = spices.filter { it[0] == 'c' }.filter { it.endsWith('e') }

val startsWithC1 = spices.subList(0, 2).filter{ it.startsWith('c')}
val startsWithC2 = spices.take(3).filter{ it.startsWith('c')}
println(startsWithC)
[curry]

```



## Lambdas
So far, we've looked at
- named function declarations (`fun` keyword + named literal + arguments +
  function body)


Now let's look at lambdas, also known as
- anonymous functions
- function literals

A lambda is an EXPRESSION that makes a function

Instead of declaring a NAMED FUNCTION, we declare a function that has no name.


A lambda is always surrounded by curly brackets in Kotlin
```kotlin
// normal function
fun myPrint() {
  println("Hello")
}


// our Lambda
{ println("Hello") }
// () -> kotlin.Unit

// IIFE
{ println("Hello") }()
// Hellokotlin.Unit

```

Let's assign a variable to a lambda
```kotlin
val myPrint = { println("Hello") }
myPrint
// () -> kotlin.Unit
```


Lambdas can take arguments, just like named functions

The arguments go on the left hand side of the FUNCTION ARROW

The function body goes on the right hand side of the FUNCTION ARROW

```kotlin
val waterFilter = { dirty: Int -> dirty / 2 }
```


## Function types
Similar to syntax for lambdas

Now we don't have to specify the type of the lambda arguments (it's calculated
by type inference)
```kotlin
val waterFilter: Int -> Int = { dirty -> dirty / 2 }
```


```kotlin
fun feedFish(dirty: Int) = dirty + 10
```


The real power of lambdas come with Higher Order Functions.

A higher order function is any function that takes a function as the argument


```kotlin
fun updateDirty(dirty: Int, operation: (Int) -> Int) {
  return operation(dirty)
}
```


```kotlin
var dirty = 20

// lambda assigned to variable
val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }

// named function
fun feedFish(dirty: Int) = dirty + 10

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
fun dirtyProcessor() {
    // can pass the lambda into our HOF
    dirty = updateDirty(dirty, waterFilter)

    // we have to use a double :: to pass a named function into a HOF
    dirty = updateDirty(dirty, ::feedFish)
}
```

When you combine HOF with lambdas, Kotlin has a special syntax.

It's called the "last parameter syntax"
```kotlin
fun dirtyProcessor() {
    // can pass the lambda into our HOF
    dirty = updateDirty(dirty, waterFilter)

    // we have to use a double :: to pass a named function into a HOF
    dirty = updateDirty(dirty, ::feedFish)

    // direct lambda
    dirty = updateDirty(dirty) { dirty ->
      dirty + 50
    }

    // direct lambda (with parens back in)
    dirty = updateDirty(dirty, { dirty ->
      dirty + 50
    })
}

```

Using this syntax, we can define functions that look like they're built into the
language


Actually, we've already used a few.
The filter function takes a lamda as its only argument

```kotlin
list.filter {
  it == 2
}
```

Which is a nicer syntax (cleaner) than:
```kotlin
list.filter({
  it == 2
})
```


The `repeat` function takes 2 arguments: a repeat count, and a lambda!
```kotlin
repeat(2) {
  // do stuff
}
```

## Lambda Quiz
```kotlin
import java.util.*

// random1 is a value
// this captures the ONE random number
// random1 has a value assigned at compile time, and the value never changes when the variable is accessed.
val random1 = Random().nextInt(10)
println(random1)
println(random1)
println(random1)

// random2 is a function
// this generates a new random number
// random2 has a lambda assigned at compile time, and the lambda is executed every time the variable is referenced, returning a different value.
val random2 = { Random().nextInt(10) }
println(random2())
println(random2())
println(random2())
```


## Quiz 2
```kotlin
// basic lambda
val rollDice = { Random().nextInt(12) + 1 }


// this is actually returning a function
// rollDice(2)()
val rollDice = { sides: Int -> {
    if (sides == 0) 0
    Random().nextInt(12) + 1
} }

// Should be this:
// rollDice()
// note that `return` is not allowed here
val rollDice = { sides: Int ->
    if (sides == 0) 0
    Random().nextInt(sides) + 1
}


// now using the Function Type Notation
val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0
    Random().nextInt(sides) + 1
}


```


## Practice Time
Why would you want to use the function type notation instead of just the lambda?

Function type notation is more readable, which reduces errors, clearly showing
the what type is passed in and what type is returned
