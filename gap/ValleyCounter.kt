/**
 * Counts valleys within path.
 * @param path string of D and U letters standing for uphill (U) and downhill (D).
 * @return number of valleys in the path.
 * Example:
 * Having UDDDUDUU.
 * _/\      _
 *    \    /
 *     \/\/
 * Should return count equal to 1.
 */
fun countValleys(path: String): Int {
    var count = 0
    var levels = 0

    path.forEach {
        when (it) {
            'U' -> {
                ++levels
                if (levels == 0)
                    ++count
            }
            'D' -> --levels
        }
    }

    return count
}


fun testCountValleys() {
    println(countValleys("UDDDUDUU"))
}
