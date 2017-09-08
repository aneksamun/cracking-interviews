public class LonelyInteger {

    /**
     * Detects lonely integer.
     * Example:
     * 1, 1, 2, 3, 3
     * Should return 2.
     * @param integers An integers to verify
     * @return The loneluy integer
     */
    public static int detectLonelyInteger(int[] integers) {
        int value = 0;
        for (int integer : integers) {
            value ^= integer;
        }
        return value;
    }
}
