
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
