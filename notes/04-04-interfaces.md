# Interfaces

Different types of fish have lots in common and they do similar things, in
somewhat different ways

For example, all fish have a COLOR, and all fish have to EAT.

So we want to make sure that all the fish we create do that.

Kotlin offers 2 ways of doing this.
- Abstract classes
- Interfaces

Both are classes that cannot be instantiated on their own.

This means you cannot create objects of those types yet.

The difference is that abstract classes have constructors, whereas interfaces
cannot have any constructor logic.

----
## Abstract Class
Let's make a simple Abstract Class:

Abstract classes start with the `abstract` KEYWORD.

Because `AquariumFish` is abstract, we can't make instances of it directly.

We need to provide SUBCLASSES that implement its MISSING FUNCTIONALITY.

Let's create 2 subclasses!
```kotlin
abstract class AquariumFish {
    abstract val color: String
}

// subclass
// NB. we are INITIALIZING our parent here
// This type (AquariumFish) has a constructor and thus must be initialized here
class Shark: AquariumFish() {

}
```

This leaves us with errors because have to IMPLEMENT the ABSTRACT PROPERTY
"color".

```kotlin
abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish() {
    override val color = "gray"
}

class Plecostomus: AquariumFish() {
    override val color = "gold"
}
```

After doing this, we can use these subclasses like any other class!

Let's add a function `makeFish` to our `Main` file.


----
## Interface
Let's make an interface, `FishAction`, that defines an `eat` function.

Let's update our Shark and Plecostomus classes

```kotlin
class FishAction {
  fun eat()
}
```

After we add `FishAction` interface to our `Shark` Class, we get this warning:
```
Class "Shark" is not abstract, and does not implement abstract member
public abstract fun eat(): Unit
defined in Aquarium.FishAction
```

To re-order that warning,
non-abstract classes must implement the members defined in their parent abstract
class.

So let's implement `eat`:
```kotlin
class Shark: AquariumFish(), FishAction {
    override val color = "gray"

    override fun eat() {
        println("Hunt and eat fish")
    }
}
```

Note that this is wrong:
```kotlin
class Shark: AquariumFish(), FishAction() {
  // This class does not have a constructor
  // FishAction does not have a constructor
}
```


Note that we get autocomplete for our `override eat` snippet!!

So:
- Abstract classes are like a blueprint for a class and its properties?
- Interfaces are like a blue print for the methods in a class?
  - we say that our Shark Class IMPLEMENTS the FishAction interface
  - Classes implement Interfaces
  - Interfaces are implemented by classes

Now let's get our fish (instances) to eat!
```kotlin
fun makeFish() {
    val shark = Shark()
    val catfish = Plecostomus()

    println("Shark: ${shark.color}")
    println("Plecostomus: ${catfish.color}")

    shark.eat()
    catfish.eat()
}
```


----
A final thing that you can do in Kotlin when using classes that implement
interfaces, is create OBJECTS where you specify that the only thing that you can
do with them is what's defined in the interface.

Let's make a function `feedFish`, and when the fish gets the food, it eats it

```kotlin
fun feedFish(fish: FishAction) {
    // make some food then
    fish.eat()
}
```

This means that every fish that passes through `feedFish`, NEEDS to IMPLEMENT
`FishAction`.

We don't care about any other properties.

As long as it implements `FishAction`, we can use it

We specify this with our FUNCTION PARAMETER, by making it "of type FishAction"

Now, only fish that implement `FishAction` can be passed into `feedFish`

This is a simplistic example, but when you have a lot of classes, this can help
you keep clear and more organized.

----
## Difference between Abstract Classes and Interfaces
