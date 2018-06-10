# Special Purpose Classes

There are 3 other types of special purpose classes you can make with Kotlin.

The first, Kotlin removes boilerplate acrobatics from your code singletons

For example, there can only be one MobyDickWhale.

To create a singleton, use the `object` keyword when you declare your class, and
that's it.

Anytime you're defining a class that shouldn't be instantiated multiple times,
you can use the `object` keyword in place of `class`. When you do that, Kotlin
will instantiate exactly ONE instance of the class.

In this example, `MobyDickWhale` is an object, and there can only be one
`MobyDick`, so we declare it as an object, instead of a class.

## Enums
Kotlin also has enums, which let you enumerate items.

Here, we're declaring an enum with red, green, and blue colors:
```kotlin
enum class Color(val rgb: Int) {
  RED(0xFF0000),
  GREEN(0x00FF00),
  BLUE(0x0000FF)
}
```

Enums actually define a class, and you can give them properties or even methods.

You declare an enum by modifying the `class` keyword with `enum`.

Enums are like the MobyDick object.

Kotlin will make exactly ONE red, ONE green, and ONE blue.

There's no way to create more than one color object.

There's no way to define more colors, other than where the enum is declared.

## Sealed class
The last type of class in Kotlin is a SEALED class.

A sealed class is special.

It's a class that can be SUBCLASSED, but only inside the FILE in which it's
declared.

If you try to subclass it in a different file, you'll get an error.

```kotlin
sealed class Seal {

}
```

Because the class and the subclass(es) are in the same file, Kotlin will be able
to know all subclasses statically, that is, at COMPILE TIME.

The compiler can see all of the classes and subclasses, and it knows that
these are ALL OF THEM.

So the compiler can do extra checks for you.

This makes sealed classes a safe way to represent a fixed number of types.

They're great for returning success or error from a network API, for example.

```kotlin
sealed class Seal

class SeaLion: Seal()
class Walrus: Seal()
```

We've made 2 subclasses, Seal and Walrus, both types of seals.

If we want to make more seals, we have to put them in THIS FILE.
We can't subclass seal in any other file.

Since they're all in the same file, Kotlin knows statically about all of the
subclasses. We can use a `when` statement to check what type of seal we have.

```kotlin
fun matchSeal(seal: Seal): String {
  return when (seal) {
    is Walrus -> "walrus"
    // is SeaLion -> "sea lion"
  }
}
// 'when' expression must be exhaustive, add necessary 'is SeaLion' or `else` branch instead

```

And if we don't match all the different types of seal, we get a compiler error.
