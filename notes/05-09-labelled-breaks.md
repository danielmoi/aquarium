# Labelled Breaks

Kotlin has several methods of controlling flow.

We are already familar with "return" which returns from a function
to its enclosing function.

"break" is like return, but for LOOPS.

Kotlin gives you additional control over loops with what's called a
"lablled break".

```kotlin
fun labels() {
  for (i in 1..100) {
    for (j in 1..100) {
      if (i > 10) break;
    }
  }
}
```

A break qualified with a LABEL jumps to the EXECUTION POINT
right after the loop marked with that label

```kotlin
fun labels() {
  loop@ for (i in 1..100) {
    for (j in 1..100) {
      if (i > 10) break@loop
    }
  }
}
```

If `i` is greater than 10, we break, and resume execution at the label.

What this gives us is better control over NESTED LOOPS.

Any expression in Kotlin may be marked with a label.

Labels have the form an identifier followed by the @ sign.
