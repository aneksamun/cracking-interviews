/**
 * Finds a sum of even Fibonacci numbers.
 * @param upperBound The Fibonacci sequence upper number
 * @return The sum of the even Fibonacci sequence number
 * Euler problem #2
 * For 10 and sequence (1 2 3 5 8) => 2 + 8 = 10
 */
fun sumFibonacciSequenceEvenNumbers(upperBound: Int): Int {
    var previous = 0
    var current = 1
    var sum = 0

    while (current < upperBound) {
        val tmp = current
        current += previous
        if (current and 1 == 0) {
            sum += current
        }
        previous = tmp
    }

    return sum
}

/**
 * Gets the Fibonacci number when given time was made.
 * @param n The times iteration must execute.
 * @return the Fibonnaci number when given times reached.
 */
fun getFibonacciNumberIterative(n: Int): Int {
    var previous = 0
    var current = 1
    var times = n

    while (--times > 0) {
        val tmp = current
        current += previous
        previous = tmp
    }

    return current
}

/**
 * Gets the Fibonacci number when given times was made.
 * @param n The times recursion must run.
 * @return the Fibonnaci number when given times reached.
 */
fun getFibonacciNumberRecursively(n: Int): Int {
    if (n == 0) return 0
    return if (n == 1) 1
           else getFibonacciNumberRecursively(n - 1) + getFibonacciNumberRecursively(n - 2)
}
