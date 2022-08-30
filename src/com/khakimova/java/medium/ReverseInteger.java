package com.khakimova.java.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
 * <p>
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * <p>
 * Example 1:
 * Input: x = 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: x = -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: x = 120
 * Output: 21
 */
public class ReverseInteger {
    public int reverse(int x) {
        int sign = x < 1 ? -1 : 1;
        x = sign * x;
        long reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;

            if (isOutOfRange(sign * reversed)) {
                return 0;
            }
        }
        return sign * (int) reversed;
    }

    private boolean isOutOfRange(long x) {
        return x > Integer.MAX_VALUE || x < Integer.MIN_VALUE;
    }

    @Test
    public void reverseIntegerTest() {
        assertEquals(0, reverse(1534236469));
        assertEquals(321, reverse(123));
        assertEquals(-321, reverse(-123));
        assertEquals(21, reverse(120));
    }
}
