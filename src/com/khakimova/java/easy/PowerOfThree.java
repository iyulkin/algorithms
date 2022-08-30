package com.khakimova.java.easy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * <p>
 * An integer n is a power of three, if there exists an integer x such that n == 3^x.
 * <p>
 * Solution:
 * n is an integer, that means it limited with Integer.MAX_VALUE
 * The biggest available power of 3 may be 3^19 (19 = Math.log(Integer.MAX_VALUE)/Math.log(3))
 * Since 3 is a prime number, n is a power of three if and only if n is divisor of 3^19
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }

    @Test
    public void isPowerOfThreeTest() {
        assertTrue(isPowerOfThree(27));
        assertTrue(isPowerOfThree(9));
        assertFalse(isPowerOfThree(0));
        assertFalse(isPowerOfThree(8));
    }
}
