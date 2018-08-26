# Annotations

Annotations are a means of attaching METADATA to code.

The annotations are read by the compiler, and used to generate code
or even logic.

Annotations are not Kotlin-specific, but Kotlin offers some
useful annotations.

Annotations go right BEFORE the thing that is being annotated.

Most things can be annotated: classes, functions, methods,
and even control structures.

Some annotations can even take arguments.

There are annotations available through the Kotlin standard library
that control the way code is compiled.

They're really useful if you're exporting Kotlin to Java, but otherwise,
you don't need them that often.


Here, we are saying that the EXPORTED NAME of this file is "InteropFish"
with the JvmName annotation.

The JvmName annotation is taking an ARGUMENT of "InteropFish"

```kotlin
@file: JvmName("InteropFish")
class InteropFish {
  companion object {
    @JvmStatic fun interop()
  }
}
```

Then, in the companion object, by saying JvmStatic, we tell Kotlin
to make the Interop function a STATIC FUNCTION on InteropFish.

We need to use a companion object because we're making the function static.

Many frameworks use annotations to configure how they run.

----
You can even create your own annotations.

Let's say you have a simple plant class with 2 methods:
You can then use REFLECTION to get information about the class at RUNTIME.
That's the "COLON COLON CLASS" operation
This is useful, and lets Kotlin look into the properties on classes,
or reflect.

```kotlin
class Plant {
  fun trim() {}
  fun fertilize() {}
}

// Here, we're just printing all the methods on this class
fun reflections() {
  val classObj = Plant::class
  for (method in classObj.declaredMemberFunctions) {
    println(method.name)
  }
}
```

----
Let's write a really basic annotation
It doesn't do anything other than tell you it's annotated

```kotlin
annotation class ImAPlant
```

And you use it like this!
```kotlin
@ImAPlant class Plant {
  fun
}
```

You can get all the annotations for a class, and do something in response,
such as print them,

One important thing to know, because it comes up a lot when using
frameworks, annotations can target getters or setters.

When they dok you can apply them with the "GET COLON"

Our "OnGet" can only be applied to property getters
And our "OnSet" can only be applied to property setters


Annotations are really powerful for creating libraries that inspect
annotations both at runtime and sometimes at compile time.

However, typical application code just uses annotations PROVIDED by
FRAMEWORKS