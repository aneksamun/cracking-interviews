public final class SubArray {

    /**
     * Calculates maximum sub array using brute-force approach
     * @param array of integers
     * @return maximum sum
     */
    public static int calculateMaximum(int[] array) {
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int current = i;
                int sum = 0;
                while (current <= j) {
                    sum += array[current];
                    current++;
                }
                if (max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

}
