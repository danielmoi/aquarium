# Functions

```
fun printHello() {
  println("Hello")
}
```

We execute the function by invoking its NAME

## IntelliJ
Right Click > New > Kotlin File/Class > AMS.kt

To run a Kotlin program, we need a `main` function.

`main` is always the entry point for execution.

The FUNCTION BODY is in the curly braces.

```
fun main(args: Array<String>) {
  println("Hello, world!")
}
```

`args` is a PARAMETER NAME


Every function in KT returns something, even when it is not explicitly specified.

Our `main` will return a UNIT, which is Kotlin's way of saying "no value"

We don't have to annotate this.
```kotlin
fun main(args: Array<String>) {
  println("Hello, world!")
}
```

To run, Green Triangle > Run AMSkt

Or, we can use `^R` (`CTRL-SHIFT-R`)


## Java Libraries
When we type:
```kotlin
fun dayOfWeek() {
  Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
}
```

IntelliJ will automatically annotate the file with an `import` statement!

```kotlin
import java.util.*
```

## Quiz
We can do this:
```kotlin
fun dayOfWeek() {
    println("What day is it today?")
    var dayNum = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    when (dayNum) {
        1 -> println("Sunday!")
        2 -> println("Monday!")
        3 -> println("Tuesday!")
        4 -> println("Wednesday!")
        5 -> println("Thursday!")
        6 -> println("Friday!")
        7 -> println("Saturday!")
        else -> println("Time has stopped...")
    }
}
```

But we can move the `println` up
```kotlin
fun dayOfWeek() {
    println("What day is it today?")
    var dayNum = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when (dayNum) {
        1 -> ("Sunday!")
        2 -> ("Monday!")
        3 -> ("Tuesday!")
        4 -> ("Wednesday!")
        5 -> ("Thursday!")
        6 -> ("Friday!")
        7 -> ("Saturday!")
        else -> ("Time has stopped...")
    })
}
```


## Main arguments
Run > Edit Configuration > Program arguments: Kotlin

Now let's use a STRING TEMPLATE to access the value of an expression

```kotlin
fun main(args: Array<String>): Unit {
    println("Hello, ${args[0]}!")
    dayOfWeek()
}
```

We need to use the curly braces because `args[0]` is not a value.
It is an EXPRESSION.
It has to be EVALUATED to produce a VALUE.

We can say that "everything in Kotlin is an expression"

This means that we can use the value of an IF EXPRESSION right away

```kotlin
val isHot = if (temperature > 50) true else false
```

We don't need to create an extra variable to figure out which branch is taken!


We can even use our IF EXPRESSION inside a string template, because it is an expression!
```kotlin
val message = "You are ${if (temperature > 50) "hot" else "fine"}"
```



## Exercise: Greetings, Kotlin
```kotlin
fun main(args: Array<String>) {
    var message = "Good ${if (args[0].toInt() < 12) "morning" else "night"}, Kotlin"
    println(message)
}
```
## Random Day
```kotlin
fun randomDay() : String {
    val week = listOf<String>("Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}
```

`Random` is a Java library.
`7` is the boundary, and is excluded.


## Fortune Cookies
`main` must have an `args: Array<String>` for the file to be Run-able (why?)


```kotlin
fun main(args: Array<String>) {

    var count = 10
    do {
        println("Enter your birthday: ")
        getAndPrint()
        count -= 1
    } while (count > 0)
}
```

Using `break`:
```kotlin
fun main(args: Array<String>) {
   var fortune: String
  for (i in 1..10) {
    fortune = getFortune()
    println("\nYour fortune is: $fortune")
    if (fortune.contains("Take it easy")) break
  }
}
```

## Fish food
NB for the `when` statement, it automatically breaks.
This reduces the boilerplate, and reduces the chance of writing accidental bugs.
```kotlin
fun fishFood(day: String): String {
    var food = "fasting"
    when (day) {
        "Monday" -> food = "flakes"
        "Tuesday" -> food = "pellets"
        "Wednesday" -> food = "redworms"
        "Thursday" -> food = "granules"
        "Friday" -> food = "mosquitos"
        "Saturday" -> food = "lettuce"
        "Sunday" -> food = "plankton"
    }
    return food
}
```

Since everything in Kotlin has a value, `when` has a value too -

the last value of the expression of the branch that was picked

So we can do this (NB we have to use an `else`)
```kotlin
fun fishFood(day: String): String {
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitos"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}
```

## Default parameters
```kotlin
fun swim(speed: String = "fast") {
    println("Swimming speed: $speed")
}
```

we can invoke it positionally:
```kotlin
  swim("slow")
```

Or we can specify the argument by name:
```kotlin
  swim(speed: "slow")
```

We can mix things up
```kotlin
  swim(50, sleep = "slow")
```

It is best practice to put arguments without defaults first.

## Sum
Wrong:
```kotlin
var currentTotalSize = currentFish.reduce { acc, i -> acc += i }
```
Error: Val cannot be reassigned (we cannot reassign `acc`)



Also wrong:
```kotlin
var currentTotalSize = currentFish.reduce { acc, i -> acc + i; 0 }
```
This will return zero. I think because the return value becomes `0`, regardless of the reduce function.


This is how we reduce:
```kotlin
var currentTotalSize = currentFish.reduce { acc, i -> acc + i }
```

If we want to specify an initial value, we have to use `fold`:
```kotlin
var currentTotalSize = currentFish.fold(0) { acc, i -> acc + i }
```

Caveat: we cannot reduce over an empty list:
```
Exception in thread "main" java.lang.UnsupportedOperationException: Empty collection can't be reduced.
	at AMSKt.canAddFish(AMS.kt:97)
	at AMSKt.main(AMS.kt:16)
```
Use `fold` instead

## My solution
```kotlin
fun canAddFish(
        tankSize: Double,
        currentFish: List<Int>,
        newFishSize: Int = 2,
        hasDecorations: Boolean = true
        ) {
    val currentFishLength = currentFish.fold(0) { acc, i -> acc + i }

    val maxLength = if (hasDecorations) {
       tankSize * 0.8
    } else tankSize

    val can = currentFishLength + newFishSize <= maxLength
    return can
}
```

## Course solution
- uses `List.sum()`
- single line logic (maxLength >= newFishLength)
```kotlin
fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}
```


## Activity
```kotlin
fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24) {
    when (mood) {
        mood == "happy" && weather == "Sunny" -> "Go for a walk"
        else -> "Stay home and read"
    }
}
```
Error: `error: incompatible types: Boolean and String`

Thought it was types:
```kotlin
fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24): String {
    return when (mood) {
        mood == "happy" && weather == "Sunny" -> "Go for a walk"
        else -> "Stay home and read"
    }
}
```

But it was SYNTAX:
It was saying that `mood` is a Boolean...

This is because `when` is a conditional, and `mood` was being coerced into a boolean (if String is present, then `true` else `false`)
We can use `when` without parameters.

With this usage, it acts as a series of `if`/`else` checks:
```kotlin
fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24): String {
    return when {
        mood == "happy" && weather == "Sunny" -> "Go for a walk"
        else -> "Stay home and read"
    }
}
```

## Clean code
```kotlin
fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = 22): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false

    }
}
```
This is complex.

We can Kotlinize it.

We can specify variables that provide a name for each logic test at the beginning of the function body.

We should use good names, that indicate what we are testing:

Then we should assign the results of the tests to these variables:
```kotlin
fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = 22): Boolean {

    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    return when {
        isTooHot -> true
        isDirty -> true
        isSunday -> true
        else -> false

    }
}
```

Then we can extract these tests into functions:
```kotlin
fun isTooHot(temperature: Int) : Boolean = temperature > 30
fun isDirty(dirty: Int) : Boolean = dirty > 30
fun isSunday(day: String) : Boolean = day == "Sunday"
```

We can exclude the return type, because it is inferred.
The function names give a hint to the return value type
```kotlin
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"
```

We can declare functions in this way, whenever there is a single expression in the body.

Now we can call these functions in the `when` statement:

```kotlin
fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = 22): Boolean {

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false

    }
}
```

##
Instead of assigning a fixed value as the default parameter,

We can assign a function, whose return value becomes the default value!

```kotlin
fun getDirtySensorReading() = 20
```

Giving us this:
```kotlin
fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: getDirtySensorReading()): Boolean {

    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false

    }
}
```

---

Sometimes you might be tempted to use expensive functions to
initialize default parameters.

Examples of expensive operations:
- reading files
- allocating a lot of memory

This is because default parameters are evaluated at CALL TIME.

We can risk:
- slowing app
- running into out of memory errors

Example:
```kotlin
fun makeNewAquarium() = println("Building a new aquarium...")

fun aquariumStatusReport(aquarium: Any = makeNewAquarium()) {
  // stuff
}
```

When we call `aquariumStatusReport()`, if we have an aquarium,
then that will get passed in, but there isn't, then an entire
aquarium is built, which will take a long time and a lot of
resources.

If a report is requested, and called without arguments, a new aquarium will be built every time.
This is inaccurate, and if a lot of reports are requested, then
the application will run out of memory.


## Other control features
- `when`
- `if` / `else`
- `while`

- there is also `repeat` in the standard library:
```kotlin
repeat(2) {
  println("A fish is swimming!")
}
```

This is actually an iterable, and there is `it` with the type `Int`
behind the scenes.


a `for` loop has no value, so assigning it to a variable will
produce an error
```
for is not an expression, and only expressions are allowed here
val noValue = for (x in 1..2) {}

while is not an expression, and only expressions are allowed here
val notThisEither = while (false) {}

