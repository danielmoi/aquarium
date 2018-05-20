val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

val sorted = spices.sorted()

val sorted1 = spices.filter { it.contains("curry") }.sortedBy { it.length }
val sorted2 = spices.sorted()

val withCE1 = spices.filter { it[0] == 'c' && it.endsWith('e') }
val withCE2 = spices.filter { it[0] == 'c' }.filter { it.endsWith('e') }

val startsWithC1 = spices.subList(0, 2).filter { it.startsWith('c') }
val startsWithC2 = spices.take(3).filter { it.startsWith('c') }
