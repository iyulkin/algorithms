package com.khakimova.java.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOne {

    @Test
    public void test() {
        assertThat(plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}), is(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}));
    }

    private int[] plusOne(int[] digits) {
        return increment(digits, digits.length - 1, 1);
    }

    private int[] increment(int[] digits, int i, int v) {
        if (digits == null || i >= digits.length || v == 0) {
            return digits;
        }
        if(i < 0) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = v;
            for(int j = 0; j < digits.length; j++) {
                newArray[j+1] = digits[j];
            }
            return newArray;
        }
        int num = digits[i] + v;
        digits[i] = num % 10;
        return increment(digits, i - 1, num / 10);
    }
}
