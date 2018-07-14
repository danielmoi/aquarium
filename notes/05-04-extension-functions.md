# Extension Functions

Utility functions that add helpful behaviour to a class?

Kotlin provides a convenient syntax for declaring these util functions:
Extension functions.

Extension functions allow you to add functions to an existing class, without
having access to its source code!

For example, you could declare them in `extensions.kt` as part of your package.

You specify the class(es) extended before the dot.
Then the function name.
Inside the extension function, `this` is bound to the instance it's called on.

```kotlin
fun String.hasSpaces(): Boolean {
  val found: Char? = this.find { it == ' ' }
  return found != null
}
```

Under the hood, extensions do NOT actually modify the classes they extend.

By defining an extension, you do not insert new members into the class, we
merely make a new function callable with the dot-notation on variables of this
type.

Once you define an EF, it's available as if it were declared on the class.

----
We can make `hasSpaces` much shorter in Kotlin.
We don't need to explicitly say `this`, just like in member functions.
The call will find and implicitly use `this`

We also don't need to use braces around the body, since it can be represented as
ONE EXPRESSION

```kotlin
fun String.shorterHasSpaces() = find { it == ' '}
```

EF are a great way to add helpful functionality to classes you don't own.

----
You can also use it to separate the CORE API from helper methods on classes you
do own.

For example, AquariumPlant.

AquariumPlant.isRed is a helper, but it's not really part of the core API of
AquariumPlant.

By defining it as a helper function, we clearly SHOW that it's just a helper.

----
NB. Extension functions are defined OUTSIDE of the class they extend, so they
don't get access to private variables.

EF are like helper functions that rely on the PUBLIC API of the class.

----
EF are always resolved STATICALLY on the variable they're applied to.

this is because the extension function is RESOLVED statically
ie. at compile time
And the compiler just looks at the TYPE of the VARIABLE

----
You can define extension PROPERTIES too!


We define a GETTER method

When we access that property, it actually CALLS the GETTER METHOD (just like any
regular property / getter).

----
You can also make the class you're extending (also called the RECEIVER),
nullable.
If you do that, then the `this` variable used in the body can be null
- ie. the object on which the extension function is called can be null.

We would want to take a nullable receiver if you expect the callers to want to
call your extension function on nullable variables.

Or, if you want to provide a default behaviour when your function is applied to
null.


----
Extension functions are really powerful.

Most of the Kotlin standard library is actually implemented as extension
function!

So.
Extension functions are for adding extra functionality to a CLASS.



