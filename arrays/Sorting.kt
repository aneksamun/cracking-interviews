fun bubbleSort(array: IntArray) {
    val n = array.size
    for (i in 0 until n - 1)
        for (j in 0 until n - i - 1)
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
}

/**
 * Sorts an array by one swap.
 * Having {10, 20, 60, 40, 50, 30}
 * Starts with `30` and compares with previous number
 * finding an item smaller than it, e.g., `20` and does swap with it.
 */
fun sortByOneSwap(array: IntArray): IntArray {
    for (i in array.size - 1 downTo 0) {
        var j = i - 1

        while (j >= 0 && array[i] < array[j]) j--

        val tmp = array[i]
        array[i] = array[j + 1]
        array[j + 1] = tmp

        break
    }

    return array
}

/**
 * Determines whether array is sortable by single swap.
 * Having {10, 20, 60, 40, 50, 30}
 * returns `true`.
 */
fun isSortableBySingleSwap(array: IntArray): Boolean {
    val leftIndex = findLeftIndex(array)
    val rightIndex = findRightIndex(array)
    if( leftIndex == rightIndex || leftIndex ==-1 || rightIndex == -1)
        return false

    val tmp = array[leftIndex]
    array[leftIndex] = array[rightIndex]
    array[rightIndex] = tmp

    return isSorted(array)
}

private fun findRightIndex(array: IntArray): Int {
    var i = array.size - 1
    while (i >= 1) {
        when {
            array[i - 1] > array[i] -> {
                while (i < array.size - 1 && array[i] == array[i + 1]) i++
                return i
            }
            else -> i--
        }
    }
    return -1
}

private fun findLeftIndex(array: IntArray): Int {
    var i = 0
    while (i < array.size - 1) {
        when {
            array[i] > array[i + 1] -> {
                while (i > 0 && array[i] == array[i - 1]) i--
                return i
            }
            else -> i++
        }
    }
    return -1
}

private fun isSorted(array: IntArray): Boolean {
    return (0 until array.size - 1).none { array[it] > array[it + 1] }
}
