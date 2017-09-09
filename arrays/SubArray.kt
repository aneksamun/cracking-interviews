/**
 * Calculates maximum sub array using brute-force approach
 * @param array of integers
 * @return maximum sum
 */
fun calculateMaxSubArraySum(array: IntArray): Int {
    var max = array[0]

    for (i in array.indices) {
        for (j in i until array.size) {
            var current = i
            var sum = 0
            while (current <= j) {
                sum += array[current]
                current++
            }
            if (max < sum) {
                max = sum
            }
        }
    }

    return max
}

/**
 * Calculates maximum sub array using Kanade approach
 * @param array of integers
 * @return maximum sum
 */
fun calculateMaxSubArraySumByKanade(array: IntArray): Int {
    val size = array.size
    var maxSoFar = Integer.MIN_VALUE
    var maxEndingHere = 0

    for (i in 0 until size) {
        maxEndingHere += array[i]
        if (maxSoFar < maxEndingHere)
            maxSoFar = maxEndingHere
        if (maxEndingHere < 0)
            maxEndingHere = 0
    }
    return maxSoFar
}

fun testSubArrayMaximumCalculation() {
    println(calculateMaxSubArraySumByKanade(intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)))
}
