public class CountBits {
    /**
     * Counts bit '1' presence in given number.
     * @param value The number to inspect
     * @return the count of bit '1' in a given number
     */
    public static int countPopulation(int value) {
        int count = 0;

        while (value > 0) {
            if (value % 2 == 1) {
                count++;
            }
            value /= 2;
        }

        return count;
    }
}
