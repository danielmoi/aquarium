# Generic Functions

Sometimes we want to make a generic function.

This is a good idea whenever the function takes an argument of a CLASS THAT HAS A GENERIC.

Let's make a function.
We need to specify the GENERIC TYPE of the parameter.
We could use Aquarium, but this means that Aquarium must have an Out Type parameter for this to be called
```kotlin
fun isWaterClean(aquarium: Aquarium<WaterSupply>) {
  println("aquarium water is clean? ${aquarium.waterSupply.needsProcessed}")
}
```

We can add a generic to a function by adding angle brackets right after the keyword "fun"
```kotlin
fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
  println("aquarium water is clean? ${aquarium.waterSupply.needsProcessed}")
}
```

And we call the function like so:
```kotlin
fun example() {
  isWaterClean<TapWater>(aquarium)
}
```

Because of type inference, we don't need to explicitly use the angle brackets.
The compiler figures it out from the Aquarium Type.
```kotlin
fun example() {
  isWaterClean<TapWater>(aquarium)
}
```

---
We can use generic functions for methods too, even in classes that have their own generic type.

Let's add one to aquarium that lets us check if it has a type of water supply

---

Let's move hasWaterSupplyOfType to be an extension function!

----
In and out, generic functions, reified, star projections.

Only ONE more topic, and that will be a good start to Kotlin generics!

TYPE ERASURE.
This will come up in some error messages that the compiler produces

All generic types are only used at COMPILE TIME by Kotlin.
This lets the compiler make sure that you're doing everything safely.
However, at RUNTIME, all the generic types are erased.

The compiler can create completely correct code without keeping the generic types to runtime.

But it does mean that sometimes you do something like "isChecks" on a generic type 
that the compiler can't support.

That's why Kotlin added reified or REAL TYPES.

