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
There is really ONE different in syntax between Abstract Classes amd Interfaces

Abstract Classes (can) have constructors.

Both Abstract Classes and Interfaces can contain implementation of methods
(functions).

On interfaces, we call them "Default Implementations"

The big difference is in WHEN and HOW you use them.

Use an Interface if you have a lot of methods and 1 or 2 default implementations
```kotlin
interface AquariumAction {
  fun eat()
  fun jump()
  fun clean()
  fun catchFish()

  fun swim() {
    // default implementation
    println("Swim")
  }
}
```


Use an Abstract Class any time you can't complete a class...
```kotlin
interface FishAction {
  fun eat()
}

abstract class AquariumFish: FishAction {
  // leave "color" abstract.
  // there really isn't a good default color for fish
  abstract val color: String

  // provide default implementation of "eat"
  override fun eat() = println("Yum")
}
```


Kotlin provides a better tool for doing this: "Interface delegation"

Interface delegation allows you to add features to a class, via COMPOSITION.

Composition is when you USE an instance of another class, as opposed to INHERITING
from it.

Instead of requiring the caller's subclass, a giant abstract class, give them a
SMALL INTERFACE, and let them delegate THOSE interfaces to an object.

This sounds pretty abstract.

How do we DO composition?

Let's define a new `main` function, to explore composition.

Let's implement `delegate` to create a catfish, and print its color and food.

Let's start by breaking up `AquariumFish` into interfaces!
FishAction, and FishColor.


Now we need to update `catfish` to implement both the fish action, and the fish
color

We can REMOVE INHERITANCE from `AquariumFish`, because we get all the
functionality from the INTERFACES!

And we don't even have to change the code in the body of plecostomus.
```kotlin
package Aquarium

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val catfish = Plecostomus()
    println("Fish has color ${catfish.color}")
    catfish.eat()
}

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

class Plecostomus: FishAction, FishColor {
    override fun eat() {
        println("Eat algae")
    }

    override val color: String
        get() = "gold"
}
```

Next, let's use INTERFACE DELEGATION to provide a color implementation.

To do that, we need an OBJECT that knows how to provide a fish color.

Let's make a basic object, called GoldColor that implements fish color!

```kotlin
class GoldColor: FishColor {
    override val color = "gold"
}
```

All it does is say that its color is gold.

It doesn't make sense to make multiple instances of GoldColor because they would
all do the exact same thing.

Kotlin allows us to declare a class where we can only have ONE INSTANCE, by
using the keyword "object" instead of "class".

ie. the keyword `object` makes a class SPECIAL - we can make an instance of it,
but only ONCE.

```kotlin
object GoldColor: FishColor {
    override val color = "gold"
}
```
This will declare a class and make exactly ONE INSTANCE of it.
The instance is called `GoldColor` and there's no way to make another instance
of this class.

If you're familiar with the Singleton pattern, this is how to implement it in
Kotlin.

We're all set to use "Interface Delegation" now.

In `Plecostomus`, we say `by GoldColor` next to `FishColor`.

And we remove the MEMBER VARIABLE `color`:

```kotlin
class Plecostomus: FishAction, FishColor by GoldColor {
  override fun eat() = println("Eat algae")

  // we have removed
  // override fun color() = "gold"
}
```

This means:
- implement the interface fish color, by deferring all calls TO THE OBJECT
  `GoldColor`

So every time you call the color property on the `Plecostomus` class, it will actually call
the color property on the `GoldColor` object!!

Of course, there are DIFFERENT colors of plecostomi in the world.

So, we can make the `FishColor` object a CONSTRUCTOR PARAMETER with a default
value of GOLD.

And defer CALLS to the COLOR property to whatever fish color we get passed in.

```kotlin
class Plecostomus(fishColor: FishColor = GoldColor()) : FishAction, FishColor by fishColor {
    override fun eat() {
        println("Eat algae")
    }
}
```

We can delegate print fish action to a class too, and we don't need the curly
braces anymore either, because our `Plecostomus` doesn't have a body!!

All its overrides are handled by interface delegation.


```kotlin
class Plecostomus2(fishColor: FishColor2 = GoldColor()) :
        FishAction2 by PrintingFishAction("A lot of algae"),
        FishColor2 by fishColor
```


----
## Summary
Interface delegation is really powerful.

And you should generally consider how to use it whenever you might use an
abstract class in another language.

It lets you use composition to plug-in behaviours!

Instead of requiring a lot of SUBCLASSES, each specialized in a different way.
