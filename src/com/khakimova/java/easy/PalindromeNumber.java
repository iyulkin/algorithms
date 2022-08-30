package com.khakimova.java.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Given an integer x, return true if x is palindrome integer.
 * <p>
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * For example, 121 is a palindrome while 123 is not.
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        List<String> list = Arrays.stream(String.format("%d", x).split("")).collect(Collectors.toList());

        int i = 0;
        while (i < list.size()/2) {
            if(!Objects.equals(list.get(i), list.get(list.size()-1-i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Test
    public void isPalindromeTest() {
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(123));
    }
}
