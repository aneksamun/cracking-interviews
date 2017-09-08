public class Fibonacci {
    /**
     * Finds a sum of even Fibonacci numbers.
     * @param upperBound The Fibonacci sequence upper number
     * @return The sum of the even Fibonacci sequence number
     * Euler problem #2
     */
    public static int sumFibonacciSequenceEvenNumbers(int upperBound) {
        int previous = 0, current = 1, sum = 0;

        while (current < 10) {
            int tmp = current;
            current = previous + current;
            if ((current & 1) == 0) {
                sum += current;
            }
            previous = tmp;
        }

        return sum;
    }

    /**
     * Gets the Fibonacci number when given time was made.
     * @param n The times iteration must execute.
     * @return the Fibonnaci number when given times reached.
     */
    public static int getFibonacciNumberIterative(int n) {
        int previous = 0;
        int current = 1;

        while ((--n) > 0) {
            int tmp = current;
            current = current + previous;
            previous = tmp;
        }

        return current;
    }

    /**
     * Gets the Fibonacci number when given times was made.
     * @param n The times recursion must run.
     * @return the Fibonnaci number when given times reached.
     */
    public static int getFibonacciNumberRecursively(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return getFibonacciNumberRecursively(n - 1) + getFibonacciNumberRecursively(n - 2);
    }
}
