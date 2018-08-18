# Generic In and Out

If we look at our Aquarium class, we can see that the generic class is only
ever returned by the property water supply

We didn't define any functions that take a value of type T as a parameter.

Kotlin lets us define "OUT TYPES" for this.

Out types are TYPE PARAMETERS that only ever occur in RETURN VALUES of FUNCTIONS.

Or, on "val" properties.

If we try to pass an Out Type as a parameter to a function, Kotlin will give us a compiler error

Once we make a generic type an Out Type, Kotlin can infer extra information about
whether our types are safe to use.

Let's define a function that expects an aquarium of water watersupply


----
## In Types

In Types are from the same school as Out Types

In types can be used any time the generic is only used as an argument to functions.

More specifically, In Types can only be PASSED IN to an object

(Out Types can only be passed out of an object, or returned)

There's one special time you can pass an out type: Constructors can take out types as arguments
(Functions never can)

Let's make an interface cleaner that lets us clean different water supplies.

---

In types = for parameters

Out types = for return values

The IDE will suggest we add in/out to generic types.
Look for the warning!

