import kotlin.coroutines.experimental.buildSequence

/**
 * Finds all pairs in the array that sum to a number equal to K.
 * Having array of {1, 2, 3, 4, 5, 6, 7} and sum of 9
 * Result must be
 * (2, 7)
 * (3, 6)
 * (4, 5)
 */
fun findPairs(numbers: IntArray, k: Int) = buildSequence {
    var lowest = 0
    var hightest = numbers.size - 1

    while (lowest < hightest) {
        val sum = numbers[lowest] + numbers[hightest]
        when {
            sum > k -> hightest--
            sum < k -> lowest++
            else -> {
                yield(Pair(numbers[lowest], numbers[hightest]))
                hightest--
                lowest--
            }
        }
    }
}

fun testFindPairsForGivenSum() {
    val sum = 9
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val pairs = findPairs(numbers, sum).toList()
    pairs.forEach { pair -> println(pair) }
}

/**
 * Counts the number of pairs of integers whose difference is K
 * @param numbers The numbers to traverse
 * @param k The value which difference of two other numbers should match
 * @return the count of pairs
 */
fun countPairsForDifference(numbers: IntArray, k: Int): Int {
    var total = 0
    var current = 0
    var next = 1

    numbers.sort()

    while (next < numbers.size) {
        val difference = numbers[next] - numbers[current]
        when {
            difference < k -> ++next
            difference > k -> ++current
            else -> {
                ++total
                ++next
            }
        }
    }

    return total
}

fun testCountPairsForGivenDifference() {
    val sum = 1
    val numbers = intArrayOf(7, 6, 2, 5)
    val pairs = countPairsForDifference(numbers, sum)
    println("Total pairs $pairs")
}

/**
 * Counts pairs within array.
 * @param pile The numbers to traverse
 * @return count
 * Example:
 * [1, 2, 1, 2, 1, 3, 2]
 * 2
 */
fun countPairs(pile: IntArray): Int {
    var pairs = 0
    val unique = hashSetOf<Int>()

    for (current in pile) {
        if (!unique.add(current)) {
            unique.remove(current)
            pairs++
        }
    }

    return pairs
}
