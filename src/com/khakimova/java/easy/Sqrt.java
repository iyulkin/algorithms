package com.khakimova.java.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sqrt {

    @Test
    void test() {
        assertEquals(2, mySqrt(4));
        assertEquals(2, mySqrt(8));
        assertEquals(46339, mySqrt(2147395599));
    }
        // binary search
        public int mySqrt(int x) {
            if(x < 2) {
                return x;
            }

            int left = 0;
            int right = x;

            while(right - left > 1) {
                int median = (right - left)/2 + left;
                int m = x / median;
                if(m == median) {
                    return median;
                }
                if(m < median) {
                    right = median;
                } else {
                    left = median;
                }
            }
            return left;
        }
}
