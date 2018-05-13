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

