# Constants

In Kotlin, we can make top level constants, and assign them a value at COMPILE
TIME using `const val`...

So we have `val` and `const val`

For both, we can assign a value directly

But for `const val`, the value is always determined at COMPILE TIME.

With `val`, the value that is assigned can be determined during program
execution.

For `val` , we can assign it the return value from a function, because we can
set it during execution.

However, because `const val` is set at compile time, we cannot call and execute
a function to get its value set.

`const val` only works at the top level, and in classes declared with `object`,
not with regular classes declared with `class`.

----
Kotlin does not have a concept of CLASS-LEVEL constants.

To define constants in a class, you have to wrap them into a COMPANION OBJECT.

```kotlin

```

The basic difference between COMPANION OBJECTS and regular OBJECTS is:
- COMPANION OBJECTS are initialized from the STATIC CONSTRUCTOR of the
  containing class
  - ie. they are created when the class/object is CREATED
- PLAIN OBJECTS are initialized LAZILY on the first ACCESS to that object
  - ie. they are created when they are first USED

---
## Constants / ENUM / Data class?

- CONSTANT
Storing simple values without any functionality.
For example, a URL or a numeric code.

- ENUM
They are objects that store groups of values that are related.
They offer type safety

- DATA CLASS
Creating objects that only have properties without additional functionality.
They are class instances, so they are objects
- good for grouping properties
- a group of values
