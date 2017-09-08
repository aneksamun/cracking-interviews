public class DividerMath {

    /**
     * Finds smallest positive number that is evenly divisible.
     * Example:
     * 1..10 => 2520
     * 1..20 => 232792560
     * @param startNumber The start number, for example, 1
     * @param endNumber The end number, for example, 10
     * @return
     * Euler problem #5:
     * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
     * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
     */
    public static int findSmallestPositiveEvenlyDivisibleNumber(int startNumber, int endNumber) {
        int common = 1;
        for ( ; startNumber <= endNumber; startNumber++) {
            common = findLeastCommonMultiple(common, startNumber);
        }
        return common;
    }

    /**
     * Finds the least common number of two numbers
     * Examples:
     * 15 and 25 has common 75
     * @param smaller the smallest number
     * @param larger the largest number
     * @return The least common number
     */
    public static int findLeastCommonMultiple(int smaller, int larger) {
        return (smaller / findGreatestCommonDivider(smaller, larger)) * larger;
    }

    /**
     * Examples:
     * 21 is the divider greatest for 252 & 105 => 252 = 21 * 12; 215 = 21 * 5
     * @return The greatest common divider for numbers
     */
    public static int findGreatestCommonDivider(int smaller, int larger) {
        if (smaller > larger) {
            int tmp = smaller;
            smaller = larger;
            larger = tmp;
        }

        while (true) {
            int remainder = larger % smaller;
            if (remainder == 0)
                return smaller;

            larger = smaller;
            smaller = remainder;
        }
    }
}
