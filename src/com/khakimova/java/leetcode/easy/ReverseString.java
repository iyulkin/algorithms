package com.khakimova.java.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * <p>
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
    // two pointers: O(1) space, O(n) time complexity
    public char[] reverseString(char[] s) {
        if (s.length >= 1) {
            int leftIndex = 0;
            int rightIndex = s.length - 1;

            while (leftIndex < rightIndex) {
                if (s[leftIndex] != s[rightIndex]) {
                    swap(s, leftIndex, rightIndex);
                }
                leftIndex++;
                rightIndex--;
            }
        }
        return s;
    }

    private void swap(char[] s, int leftIndex, int rightIndex) {
        char charAtLeftIndex = s[leftIndex];
        s[leftIndex] = s[rightIndex];
        s[rightIndex] = charAtLeftIndex;
    }

    @Test
    public void reverseStringTest() {
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, reverseString(new char[]{'h', 'e', 'l', 'l', 'o'}));
        assertArrayEquals(new char[]{'h', 'a', 'n', 'n', 'a', 'H'}, reverseString(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}));
    }
}
