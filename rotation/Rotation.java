public class Rotation {

    /**
     * Rotates an array n times.
     * Brute force solution.
     * @param numbers The numbers to rotate.
     * @param times The times to rotate.
     * @return Rotated numbers.
     */
    public static int[] rotateArray(int[] numbers, int times) {
        while (times > 0) {
            int last, previous = numbers[numbers.length - 1];
            for (int i = numbers.length - 1; i >= 1; i--) {
                last = previous;
                previous = numbers[i - 1];
                numbers[i - 1] = last;
            }
            numbers[numbers.length - 1] = previous;
            times--;
        }
        return numbers;
    }

    /**
     * Rotates an array n times.
     * Module solution.
     * @param numbers The numbers to rotate.
     * @param times The times to rotate.
     * @return Rotated numbers.
     */
    public static int[] rotateArrayByModule(int[] numbers, int times) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int newIndex = (i + times) % numbers.length;
            result[i] = numbers[newIndex];
        }
        return result;
    }
}
