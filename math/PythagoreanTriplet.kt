/**
 * Finds sides: a, b, c, following a2 + b2 = c2 where a < b < c.
 * Given a + b + c = 1000.
 */
fun findPythagoreanTriplet() {
    val sideALimit = 1000 / 3
    val sideBLimit = 1000 / 2

    for (a in 1 until sideALimit) {
        for (b in 1 until sideBLimit) {
            val c = 1000 - a - b
            if (a * a + b * b == c * c) {
                println("a = $a, b = $b, c = $c")
            }
        }
    }
}
