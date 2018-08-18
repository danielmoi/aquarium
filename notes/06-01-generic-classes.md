# Generic Classes

Kotlin, like many languages, has generic types.

A generic type allows you to make a CLASS GENERIC.

If we wanted to declare a "List" class in Kotlin, we could make one for each datatype.

Here we have made a class for Integers and one for Shorts
```kotlin
class MyIntList {
  fun get(pos: Int): Int { return 0 }
  fun addItem(item: Int) {}
}

class MyShortList {
  fun get(pos: Int): Short { return 0 }
  fun addItem(item: Short) {}
}
```

Without generics, we have to implement a new copy of List for each type.
Another one for Double, one for String, and one more for Fish...

With generics, we can make the list GENERIC.
So it can hold any TYPE of object.

It's like you make the TYPE a WILDCARD that will fit many types.

---
To do that, we add a generic type to our list.

The generic type is "T".
But you can use any letter.
Or even a longer name.

This is just a convention for "type".
We put it inside angle brackets, after the class name.

We pronounce this "List of T"

```kotlin
class MyList<T> {

}
```

Now, we can use "T" inside our MyList class, as if it was a regular type
inside our class!

In this example, both the return type for "get" and the parameter type for
"addItem" are both "T":

```kotlin
class MyList<T> {
  fun get(pos: Int): T { return 0 }
  fun addItem(item: T) {}

}
```

---

To USE a generic class, you specific the type you want to use in angle brackets
WHEN you INSTANTIATE the class!

```kotlin
fun workWithMyList() {
  val intList: MyList<String>
  val fishList: MyList<Fish>
}
```

instead of this:
```kotlin
class MyIntList {
  fun get(pos: Int): Int { return 0 }
  fun addItem(item: Int) {}
}

class MyFishList {
  fun get(pos: Int): Fish { return 0 }
  fun addItem(item: Fish) {}
}

fun workWithMyList() {
  val intList: MyIntList
  val fishList: MyFishList
}
```

---
Because lists are so common, they are built into Kotlin

To talk more about generics, let's add more functionality to our aquarium.

Let's modify our Aquarium class to support different types of WATER SUPPLY.

Let's create a new package "generics", and inside that create a new Aquarium file.

This allows us to redefine stuff, using the same names, without conflicts.

NB. Files don't have to have the same name as their class.
And you can have multiple classes in one file.