import java.util.function.Predicate;

public class Palindrome {

    /**
     * Finds the largest palindrome made from the product of two 3-digit numbers
     * Example:
     * 913*993=906609
     * @return The largest palindrome made from the product of two 3-digit numbers
     * Euler problem #4:
     * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
     * Find the largest palindrome made from the product of two 3-digit numbers.
     */
    public static int findLargestPalindromeMadeByThreeNumbers() {
        Predicate<Integer> isPalindrome = origin -> {
            int reversed = 0;
            int tmp = origin;
            while (tmp > 0) {
                reversed = reversed * 10 + tmp % 10;
                tmp /= 10;
            }
            return reversed == origin;
        };

        int max = 100001;

        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                int result = i * j;
                if (max < result && isPalindrome.test(result)) {
                    max = result;
                }
            }
        }

        return max;
    }
}
