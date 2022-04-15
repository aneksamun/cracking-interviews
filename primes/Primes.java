/**
 * Defines operations over primes.
 * A Prime Number can be divided evenly only by 1, or itself.
 */

public class Primes {

    /**
     * Finds the largest prime factor
     * Example:
     * n = 6; factor = 3
     * n = 13195; factor = 29
     * @param number The number to process
     * @return The max prime factor
     * Euler task #3:
     * The prime factors of 13195 are 5, 7, 13 and 29.
     * What is the largest prime factor of the number 600851475143?
     */
    public static int findLargestPrimeFactor(long number) {
        int current;

        for (current = 2; current <= number; current++) {
            if (number % current == 0) {
                number /= current;
                current--;
            }
        }

        return current;
    }

    /**
     * Determines whether number is circular prime
     * Examples:
     * 197
     * 719
     * 971
     * 197
     * @param value the value to inspect
     * @return true when prime circular; otherwise false
     * Euler problem #35:
     * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
     * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
     * How many circular primes are there below one million?
     */
    public static boolean isCircularPrime(int value) {
        int tmp = value;

        do {
            int last = tmp % 10;
            tmp /= 10;

            int tmp2 = tmp;
            while (tmp2 > 0) {
                last *= 10;
                tmp2 /= 10;
            }

            tmp = last + tmp;

            if (!isPrime(tmp)) {
                return false;
            }

        } while (tmp != value);

        return true;
    }

    /**
     * Finds the prime number under defined sequence number
     * Example:
     * 6th prime for 2, 3, 5, 7, 11, 13 is 13
     * 1001st prime is 7927
     * Prime is the number who divides with self and 1.
     * @param limit The upper sequence number
     * @return The prime number
     * Euler problem #7:
     * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
     * What is the 10 001st prime number?
     */
    public static int findPrime(int limit) {
        int current = 2, totalPrimes = 0;

        while (true) {
            if (isPrime(current)) {
                totalPrimes++;
                if (totalPrimes == limit) {
                    break;
                }
            }
            current++;
        }

        return current;
    }

    /**
     * Determines whether number is a prime
     * @param number the number to verify
     * @return true if prime; otherwise false
     */
    public static boolean isPrime(int number) {
        if (number < 2) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;
        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
