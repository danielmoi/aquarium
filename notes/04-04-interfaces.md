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


