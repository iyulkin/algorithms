package com.khakimova.java.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */

public class FirstBadVersion {

    private boolean isBadVersion(int v) {
        return v > 1702766719 - 1;
    }

    public int firstBadVersion(int n) {
        int start = 1, finish = n, medium;

        while (start < finish) {
            medium = start + (finish - start) / 2;
            if (isBadVersion(medium)) {
                finish = medium;
            } else {
                start = medium + 1;
            }
        }
        return start;
    }

    @Test
    public void firstBadVersionTest() {
        assertEquals(1702766719, firstBadVersion(2126753390));
    }
}
