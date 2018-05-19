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
