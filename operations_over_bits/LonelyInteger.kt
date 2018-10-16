/**
 * Detects lonely integer.
 * Example:
 * Given { 1, 1, 2, 3, 3 }
 * Returns 2
 */
fun findLonelyInteger(integers: IntArray): Int {
    var lonely = 0
    for (integer in integers) {
        lonely = lonely xor integer // java: lonely ^= integer
    }
    return lonely
}
