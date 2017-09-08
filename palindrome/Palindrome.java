﻿import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    /**
     * Determines whether string is palindrome, for example, alus & sula.
     * @param s The value to verify
     * @return YES if string is palindrome; otherwise NO
     */
    public static String isPalindromeString(String s) {
        return isPalindrome("", s) ? "YES" : "NO";
    }

    private static boolean isPalindrome(String prefix, String s) {
        boolean found = false;
        if (s.length() == 0) {
            if (prefix.equals(new StringBuilder(prefix).reverse().toString())) {
                return true;
            }
        }
        else {
            for (int i = 0; i < s.length(); i++) {
                found = isPalindrome(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, s.length()));
                if (found) break;
            }
        }

        return found;
    }

    private static boolean isPalindrome(String s) {
        char[] buffer = s.toCharArray();
        int times = buffer.length;

        while (times > 0) {
            char last, previous = buffer[buffer.length - 1];
            for (int i = buffer.length - 1; i > 0; i--) {
                last = previous;
                previous = buffer[i - 1];
                buffer[i - 1] = last;
            }
            buffer[buffer.length - 1] = previous;

            char[] reverse = new char[buffer.length];
            int pos = buffer.length - 1;

            for (int i = 0; i < reverse.length; i++) {
                reverse[i] = buffer[pos];
                pos--;
            }

            if (Arrays.equals(reverse, buffer)) {
                return true;
            }

            times--;
        }

        return false;
    }

    /**
     * Detects an indices where 'haystack' part has matching 'needle' part anagram.
     * For example:
     * haystack: abbcba
     * needle: ab
     * result: { 0, 4 }
     * Explanation:
     * 0: ab = ab
     * 4: ba = ab (when rotated)
     * @param haystack the source to verify
     * @param needle the value to match
     * @return an indices of anagrams
     */
    public static List<Integer> getAnagramIndices(String haystack, String needle) {
        List<Integer> indices = new ArrayList<>();
        int len = needle.length();

        for (int i = 0; i < haystack.length(); i++) {
            int endIndex = i + len;
            if (endIndex > haystack.length() - 1) {
                break;
            }
            String substring = haystack.substring(i, endIndex);
            if (isAnagram(substring, needle)) {
                indices.add(i);
            }
        }

        return indices;
    }

    private static boolean isAnagram(String test, String origin) {
        char[] op1 = test.toCharArray();
        char[] op2 = origin.toCharArray();

        Arrays.sort(op1);
        Arrays.sort(op2);

        return Arrays.equals(op1, op2);
    }
}