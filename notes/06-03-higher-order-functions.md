# Higher Order Functions

Writing Higher Order Functions with extension lambdas is the most
advanced part of Kotlin

We used "with" in a previous lesson to APPLY SEVERAL OPERATIONS
to an object.

Let's call "with" with an object:

Then, inside the LAMBDA (between the curly braces), the object
is implicitly referenced by the word "this":

```kotlin
  val fish = Fish("splashy")

  with(fish.name) {
    this.capitalize()
  }

```

"With fish name, call this.capitalize"

We don't actually need "this" because it's IMPLICIT.

Under the hood, "with" is a HOF.

We can make our (highly simplified) of "with" that works for strings.

----
Let's make "myWith" that takes 2 arguments
- the object on which to execute the operation
- a function that defines the operation to execute on the object
  - we can call this function anything
  - by CONVENTION, it's called "block"
  - after the ":", we specify the CLASS we are EXTENDING (String)
  - we want to use "myWith" on a string, so we need to extend the String CLASS
  - the class we are extending is called the RECEIVER OBJECT
  - finally, we need to specify the RETURN TYPE of the function argument (nothing: Unit)

Now, "block" is an extension function on a string object, and we can apply it to a string

So, we can apply the passed-in function to the passed-in argument

---
Now, "with" is already provided for us in the Standard Library, we it is just one example.

----
There are many other examples of built-in functions that use extension lambdas.

"run" is an extension that works with all data types.

It takes one lambda as its argument, and returns the result of executing the lambda.

----
"apply" is similar to run, and can also be used on all data types.

unlike run (which returns the result of the block function), "apply" returns the OBJECT
it's applied TO.

"apply" is really useful for calling functions on a newly created object.

This is a really common pattern for INITIALIZING OBJECTS

----
There is also "let"

"let" returns a copy of the changed object.

It is particularly useful for CHAINING manipulations together.

