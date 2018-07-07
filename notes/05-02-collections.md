# Collections

There's the classic (and overused) interview question: reverse the elements of
an array.

```kotlin
val testList: List<Int>  = listOf(11,12,13,14,15,16,17,18,19);

fun reverse(list: List<Int>): List<Int> {
  val result = mutableListOf<Int>()
  for (i in 0 .. list.size-1) {
    result.add(list[list.size-i-1])
  }
  return result
}

```

That is, you hand the list to a function that loops through the list and a
second list, and adds (at the index of the second list) the elements of the
first list at the size minus index, and always remember the extra minus one to
account afor the zero-th element.

We can improve on this in Kotlin, by using `downTo` to traverse the list from
the END to the beginning (instead of from the beginning to the end).

```kotlin
fun reverseListAgain(list: List<Int>): List<Int> {
  val result = mutableListOf<Int>()
  for (i in list.size - 1 downTo 0) {
    result.add(list[i])
    // or, result.get(list[i])
  }
  return result
}

```

NB. `mutableListOf<Int>()`
- an empty list of Integer types.
- we can change the list

`listOf` is an immutable list.


But in Kotlin, we can just ask a list for it's REVERSED POSITION!

NB. List is not mutable. `reverse` returns a new list

```kotlin
val reverse = testList.reversed()
```


Kotlin designers made it simple to do stuff that you do all the time.


----
Some other predefined functions we can use on lists:

Contains: tests whether an item is in a list.

Sublist: creates a sublist from the index that's


Sum: sums all the values!!

Sumby: provide a function to let Kotlin know how to sum!
- sumBy takes a LAMBDA (inline function) that specifies what property of the
  elements to perform `.sum` on
- `it` is the default name for lambda arguments

----
## Mapping
In Kotlin you can map pretty much anything to anything else using mapOf

we can create a map of cures, with keys (symptom) and values (disease)
```kotlin
  val cures = mapOf("white spots" to "Ich", "red sores" to "hole disease")
  println("cures: ${cures}")
  // cures: {white spots=Ich, red sores=hole disease}

  println(cures.get("white spots"))
  println(cures["white spots"])
```


We can retrieve using `get`
Even shorter: ANGLE BRACKETS:


We can provide default values!
```kotlin
  println(cures.getOrDefault("NUP", "It's all ok"))
```

If we need to do more than just return a value, we can use the `getOrElse`
function.
Instead of return a default value, whatever code inside the curly braces is
executed!

```kotlin
  println(cures.getOrElse("white nup", { "Executing this function!" }))
```

----
We can also create mutable maps, where we can put and remove items.
For example, an inventory map that we can modify!

```kotlin
val inventory = mutableMapOf("fish net" to 1)
inventory.put("tank scrubber", 3)
inventory.remove("fish net")
```
SO, `listOf` and `mapOf` make IMMUTABLE COLLECTIONS
`mutableListOf` and `mutableMapOf` make MUTABLE COLLECTIONS!

Immutable collections are particularly useful in a THREADED environment where
you might be in trouble if multiple threads touch the same collection.


