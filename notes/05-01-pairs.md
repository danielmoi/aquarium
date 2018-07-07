# Pairs

Pairs are a neat Kotlin DATATYPE that allows us to define a generic pair of
values.

For example, we can associate each piece of equipment with a description of what
it's good for...

We define a variable for equipment, and set it to a PAIR,
where the first item "fishnet" is mapped to the second item, "catching fish"

```kotlin
  val equipment = "fishnet" to "catching fish"
  println("equipment: ${equipment}")
  // equipment: (fishnet, catching fish)
  println("equipment.first: ${equipment.first}")
  // equipment.first: fishnet
```

We can access the first and second ELEMENTS of this PAIR.


---
We can also CHAIN CALLS...

The Kotlin compiler will add the parentheses for you:
And you can print the first element of the first element

```kotlin
  val chained = "first" to "second" to "third"
  println("chained: ${chained}")
  // chained: ((first, second), third)
  println("chained.first: ${chained.first}")
  // chained.first: (first, second)
  println("chained.first.first: ${chained.first.first}")
  // chained.first.first: first
  println("chained.first.second: ${chained.first.second}")
  // chained.first.second: second
  println("chained.second: ${chained.second}")
  // chained.second: third
```


we can also add our own parentheses:
```kotlin
  val letKotlin = "A" to "B" to "C" to "D"
  println("letKotlin: ${letKotlin}")
  // letKotlin: (((A, B), C), D)

  val letMe = ("A" to "B") to ("C" to "D")
  println("letMe: ${letMe}")
  // letMe: ((A, B), (C, D))
```

We can also DESTRUCTURE = take apart an object, and assign those parts to
multiple variables:
```kotlin
  val data = "suburb" to "Sydney"
  val (key, value) = data
  println("key: ${key}")
  println("value: ${value}")
  // key: suburb
  // value: Sydney
```
---
There are also TRIPLETS and DESTRUCTURING COMPONENTS

We can turn a pair into a string:
```kotlin
  val data = "suburb" to "Sydney"
  val dataString = data.toString();
```


We can turn a pair into a LIST:
```kotlin
  val data = "suburb" to "Sydney"
  val dataString = data.List();
  // [suburb, Sydney]
```


What is this good for?
We can use it to return more than one values from a function

You have your function return a pair, and destructure it on arrival!
```kotlin
  val (tool, use) = giveMeATool()
  println("tool: ${tool}")
  println("use: ${use}")

  fun giveMeATool(): Pair<String, String> {
    return ("fishnet" to "catching")
  }
```

---
## Pairs Quiz
