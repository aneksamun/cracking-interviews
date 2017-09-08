public class CountBits {
    /**
     * Counts 1 bit presence in given number.
     * @param value The number to inspect
     * @return the count of 1 bit in a given number
     */
    private static int countPopulation(int value) {
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
