# Lambdas Recap

A lambda is an anonymous function - a function without a name.

We can assign a lambda to a variable, with an argument, dirty
which we divide by two, which will be returned.



```kotlin
val waterFilter = { dirty: Int -> dirty / 2 }

waterFilter(30)
// 15
```

Now, here is a data class that has one property, its name.

```kotlin
data class Fish (val name: String)

```

We can then create a variable, myFish
```kotlin
val myFish = listOf(Fish("Flipper"), Fish("Moby Dick"), Fish("Dory"))
```

---
Now let's print all the fish that contain the letter "i"