import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Euler problem #1:
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Multiples {

    /**
     * Finds a sum of the multiples of 3 and 5.
     * @param upperBound The upper number to iterate
     * @param multiples The multiples to divide with
     * @return The sum of the numbers that divides with 3 or 5
     */
    private static int findSumOfMultiples(int upperBound, int[] multiples) {
        return IntStream.range(1, upperBound)
                .filter(decimal -> Arrays.stream(multiples).anyMatch(multiple -> decimal % multiple == 0))
                .sum();
    }
}
