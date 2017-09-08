import java.util.Arrays;

public class Pairs {

    /**
     * Counts the number of pairs of integers whose difference is K.
     * @param nums The numbers to loop
     * @param k The value which difference of two other numbers should match.
     * @return the count of pairs.
     */
    public static int countPairs(int[] nums, int k) {

        Arrays.sort(nums);

        int count = 0;
        int i = 0;
        int j = 1;

        while (j < nums.length) {
            int diff = nums[j] - nums[i];
            if (diff == k) {
                count++;
                j++;
            } else if (diff > k) {
                i++;
            } else if (diff < k) {
                j++;
            }
        }

        return count;
    }
}
