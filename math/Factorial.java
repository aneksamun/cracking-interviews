import java.util.stream.IntStream;

public final class Factorial {

    /**
     * Recursive method to calculate factorial
     * @param number to calculate for
     * @return the factorial of the input number
     */
    public static int factorial(int number) {
        return number == 1 ? number : number * factorial(number - 1);
    }

    /**
     * The method which calculates factorial using {@link java.util.stream.Stream}
     * @param number to calculate for
     * @return the factorial of the input number
     */
    public static int factorialByStream(int number) {
        return IntStream.iterate(1, n -> n += 1)
                        .takeWhile(n -> n <= number)
                        .reduce(1, (acc, next) -> acc * next);
    }
}
