# Kotlin Basics

## Operators
Dividing by an integer always returns an integer

50/10
5

1/2
0

1.0/2.0
0.5

1.0/2
0.5

val fish = 2
fish * 2
4

// use primitive 'int' as an object
// object wrapper for numbers
- placing a number in an object wrapper is called BOXING
- this is implicitly done whenever it is needed in your program
1.toLong()

val boxed: Number = 1
boxed.toLong()
1

## Variables
The type is inferred, which means the compiler can figure out the type from the CONTEXT

The type becomes fixed at compile time

You cannot change the type of a variable once its type has been determined


- Literals are statically checked
- can't assign a short value to a long variable, or a byte to an int
- Kotlin does this because implicit numerical conversion is a common source of errors in programming

val b: Byte = 1
val i: Int = b

Can't assign

## Numbers
Kotlin supports underscores in numbers

val bytes = 1_000_000

## Nullability
Kotlin helps avoid null pointer exceptions

When you declare a variable's type, by default its value cannot be null.
```
var rocks: Int = null
error: null can not be a value of a non-null type Int

```

Use the question mark operator to indicate that a variable CAN be null
```
var rocks: Int? = null
```

```
var lotsOfFish: List<String?> = listOf(null, null)
var evenMoreFish: List<String>? = null
var definitelyFish: List<String?>? = null
```

The "not null assertion" operator can force your way past a nullable type in Kotlin
It will still throw an exception when it's not


goldfish!!.eat()
goldfish = null
goldfish!!.eat()
kotlin.KotlinNullPointerException

It's generally a bad idea to use it.

## Null testing
We can do a lot of null testing with the `?` operator.
Saves a lot of if/else statements

```
return fishFoodTreats?.dec() ?: 0
```


The question-mark-colon operator is called the ELVIS OPERATOR

## Learning
There is only one road to automaticity, and that's practice.


## Number Quiz
We can chain method calls.
If we call methods on numbers, then Kotlin will convert them to objects for us.
```
2.plus(71).plus(233).minus(13).div(30).plus(1)
```

## Quiz

WRONG:
var blueColor? = "BLUE"

RIGHT:
var blueColor = null
var blueColor: String? = null

var list = listOf(null, null)
list = listOf(1)
// error

var list: List<Int?> = listOf(null, null)
list = listOf(2, 2)
println(list)
[2, 2]


var list: List<Int>? = null
list = listOf(1)
// [1]


## Quiz
var nullTest: Int? = null
println(nullTest?.inc() ?: 0)
// 0

NB. .inc() doesn't take any arguments
it is the INCREMENT method
