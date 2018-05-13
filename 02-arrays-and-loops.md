## Arrays

If your variable value is a reference, then you cannot reassign it later
```
val myList = mutableListOf("tuna", "salmon", "shark")
myList = mutableListOf("Koi")
error: val cannot be reassigned
```

However, we can manipulate the elements in that list
```
myList.remove("shark")
```

## Loops
In order to loop, we need something to loop over

```
val school = arrayOf("tuna", "salmon", "shark")

```

Untyped array:
```
val hello = arrayOf("1", 2)
println(hello)
[Ljava.lang.Object;@624268ab
import java.util.*

println(Arrays.toString(hello))
[1, 2]

```

Typed array
```
val hello = intArrayOf("1", 2)
error: type mismatch: inferred type is String but Int was expected
val hello = intArrayOf("1", 2)
```

## Arrays
```
val array = Array(5) { it * 2 }
println(array)
[Ljava.lang.Integer;@3f69b166

val array = Array(5) { it * 2 }
println(array.toList())
[0, 2, 4, 6, 8]
```


## For In
var fish = 12
var plants = 5
var swarm = listOf(fish, plants)
for (element in swarm) println(element)
125

for ((index, element) in swarm.withIndex()) {
  println("Fish at $index is $element")
}
Fish at 0 is 12Fish at 1 is 5

val bigSwarm = arrayOf(swarm, arrayOf("dolphin", "whale", "tuna"))


We can do ranges
```
for (i in 'b'..'g') print(i)

for (i in 1..5) print(i)
bcdefg12345
```

## Ranges going down
for (i in 5 downTo 1) print(i)
54321

## Ranges in steps
for (i in 3..6 step 2) print(i)
35


## Lists
It's good to make a list immutable
- reduces errors in general
- prevents accidental changing of objects that were meant to be unchangeable
- in a multi-threaded environment, makes the variable thread-safe, because once
  if has been assigned by the initial thread, no thread can change it


## Quiz
```
var numbers = arrayOf(11..15)
var list = mutableListOf()
for (n in numbers) {
  list.add(n)
}
```

RIGHT:
```
var numbers = 11..15
var list: MutableList<Int> = mutableListOf()
for (n in numbers) {
    list.add(n)
}
```


```
var list: MutableList<Int> = mutableListOf()
for (n in 0..100 step 7) {
  list.add(n)
}
```
