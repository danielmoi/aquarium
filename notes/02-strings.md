# Strings

Concatenate strings
```
"hello" + "fish"
hellofish
```

Interpolate using template strings
```
val name = "Daniel"
"My name is $name"
```

## Booleans
==
Comparison by value


## If/Else
```
val numberOfFish = 50
val numberOfPlants = 23
if (numberOfFish > numberOfPlants) println("Good ratio!")
else println("Unhealthy ratio")
```

We can combine with RANGES
```
val fish = 50
if (fish in 1..100) println("Not enough fish")
else println("Enough fish")
```

## When
This is Kotlin's way of doing switching
```
when (numberOfFish) {
  0 -> println("Empty tank")
  50 -> println("Full tank")
  else -> println("Perfect!")
}
```

## Quiz
```
var fish1 = "trout"
var fish2 = "haddock"
var fish3 = "snapper"
println("I like eating $fish1 and I don't like eating $fish2 nor $fish3")
```

We can use `in` for using ranges
```
var fishName = "Trout"
when (fishName.length) {
  0 -> println("ERROR")
  in 3..12 -> println("Good fish name")
  else -> "OK fish name"
}
```
