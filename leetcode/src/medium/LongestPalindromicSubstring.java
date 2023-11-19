package medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a string s, return the longest palindromic substring in s.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: s = "cbbd"
 * Output: "bb"
 * <p>
 * Solution:
 * Check palindrome starting from center moving to edges.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            longestPalindrome = findLongerPalindrome(s, longestPalindrome, i, i);
            longestPalindrome = findLongerPalindrome(s, longestPalindrome, i, i+1);
        }
        return longestPalindrome;
    }

    private String findLongerPalindrome(String s, String longestPalindrome, int startIndex, int endIndex) {
        while (startIndex >= 0 && endIndex < s.length() && s.charAt(startIndex) == s.charAt(endIndex)) {
            if (endIndex - startIndex + 1 > longestPalindrome.length()) {
                longestPalindrome = s.substring(startIndex, endIndex + 1);
            }
            startIndex--;
            endIndex++;
        }
        return longestPalindrome;
    }

    @Test
    public void longestPalindromeTest() {
        assertEquals("bab", longestPalindrome("babad"));
        assertEquals("bb", longestPalindrome("cbbd"));
    }
}
