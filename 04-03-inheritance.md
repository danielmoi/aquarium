# Inheritance

Inheritance in Kotlin works much the same as in other class-based languages but
there are some differences

Let's say we want to have a different type of aquarium (Tower Tanks)

At the moment, our Aquarium class inherits from the top level class "Any"


We could add that to the declaration:
```kotlin
class Aquarium(): Any() {

}
```

NB: if we omit the parentheses, we get an error
```kotlin
class Aquarium(): Any {

}
// This type has a constructor, and thus must be initialized here
```


But it's not required, and doesn't give us anything extra.

----
The first thing we need to do before we can inherit from a class,
is to make that class OPEN.


By default, classes are NOT subclassable.

We have to explicitly allow it.

```kotlin
open class Aquarium(): Any {

}

class TowerTank(): Aquarium() {

}
```
We specify the inheritance / the PARENT CLASS after the colon.

We need to
- change how the volume is calculated for our tower tank aquariums.
- reduce the amount of water (it is a tall tank)

We will accomplish this by
- OVERRIDING the `water` property in `TowerTank`

If we do this, we get an error:
```kotlin
class TowerTank(): Aquarium() {
    var water = volume * 0.8
}
// 'water' hides member of supertype 'Aquarium' and needs 'override' modifier
```


We also need to override the get function for the volume

```kotlin
class TowerTank(): Aquarium() {

    // less water
    override var water = volume * 0.8
}
// `water` in Aquarium is final and cannot be overridden
```

We have errors because, just like classes, MEMBERS are not available for
sub-classing by default

This is so that we don't accidentally leak implementation details without
meaning to.

We need to make `water` and `volume` OPEN in the parent class.

