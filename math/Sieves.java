import java.util.HashSet;
import java.util.function.Predicate;

public final class Sieves {

    /**
     * Generates the sequence of non primes aka composite numbers (can be divided with more than self and 1).
     * @param limit upper limit to generated numbers
     * @return weather number is non prime or not.
     */
    public static Predicate<Integer> isInNonPrimesUpTo(int limit) {
        var sieve = new HashSet<Integer>();
        for (var n = 2; n <= (limit / 2); n++)
            for (var nonPrime = (n * 2); nonPrime <= limit; nonPrime += n)
                sieve.add(nonPrime);
        return sieve::contains;
    }
}
