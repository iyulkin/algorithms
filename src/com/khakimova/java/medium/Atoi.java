package com.khakimova.java.medium;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
 * Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
 * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
 * Return the integer as the final result.
 * Note:
 * <p>
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
 */
public class Atoi {

    public int myAtoi(String s) {
        String[] characters = s.trim().split("");
        int sign = 1;
        long integer = 0;

        for (int i = 0; i < characters.length; i++) {
            if (i == 0 && isSign(characters[i])) {
                sign = characters[i].equals("-") ? -1 : 1;
            } else if (isDigit(characters[i])) {
                integer = integer * 10 + Integer.parseInt(characters[i]);
                if(isOutOfRange(sign * integer)) {
                    break;
                }
            } else {
                break;
            }
        }
        return clamp(sign * integer);
    }

    private boolean isOutOfRange(long x) {
        return x > Integer.MAX_VALUE || x < Integer.MIN_VALUE;
    }

    private int clamp(long x) {
        return (int) Math.max(Math.min(x, Integer.MAX_VALUE), Integer.MIN_VALUE);
    }

    private boolean isSign(String s) {
        return List.of("-", "+").contains(s);
    }

    private boolean isDigit(String s) {
        return List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9").contains(s);
    }

    @Test
    public void atoiTest() {
        assertEquals(2147483647, myAtoi("9223372036854775808"));
        assertEquals(4193, myAtoi("4193 with words"));
        assertEquals(0, myAtoi("words and 987"));
        assertEquals(-42, myAtoi("   -42"));
        assertEquals(Integer.MAX_VALUE, myAtoi("96463243678"));
    }
}
