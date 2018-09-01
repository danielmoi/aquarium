package LabelledBreaks

fun noLabel() {
    for (i in 1..5) {
        for (j in 1..5) {
            if (i > 3) break
            println("i: $i, j: $j")
            // i: 1, j: 1
            // ...
            // i: 3, j: 5
        }
    }
}

fun withLabel() {
    loop@for (i in 1..5) {
        for (j in 1..5) {
            if (i > 3) break@loop
            println("i: $i, j: $j")
            // i: 1, j: 1
            // ...
            // i: 3, j: 5

            // Seems the same ??
        }
    }
}


fun main(args: Array<String>) {
    noLabel()

    withLabel()
}
