/**
 * Rotates an array n times.
 * Brute force solution.
 * @param numbers The numbers to rotate.
 * @param times The times to rotate.
 * @return Rotated numbers.
 */
fun rotateArray(numbers: IntArray, times: Int): IntArray {
    (times downTo 1).forEach { _ ->
        var previous = numbers[numbers.size - 1]
        for (i in numbers.size - 1 downTo 1) {
            val last = previous
            previous = numbers[i - 1]
            numbers[i - 1] = last
        }
        numbers[numbers.size - 1] = previous
    }
    return numbers
}

/**
 * Rotates an array n times.
 * Module solution.
 * @param numbers The numbers to rotate.
 * @param times The times to rotate.
 * @return Rotated numbers.
 */
fun rotateArrayByModule(numbers: IntArray, times: Int): IntArray {
    val result = IntArray(numbers.size)
    for (i in numbers.indices) {
        val newIndex = (i + times) % numbers.size
        result[i] = numbers[newIndex]
    }
    return result
}

/*
1 2 3
2 3 1
3 1 2
*/
fun test() {
    println(rotateArray(intArrayOf(1, 2, 3), 2).joinToString()) // => 3 1 2
    println(rotateArrayByModule(intArrayOf(1, 2, 3), 2).joinToString()) // => 3 1 2
}
