package com.khakimova.hard;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * <p>
 * A good array is an array where the number of different integers in that array is exactly k.
 * <p>
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,
 *
 * Решение:
 * 1. We should count number of subarrays with atmost k distinct elements using sliding window technic. These will include subarrays with [1 .. k] distinct elements.
 * 2. We should count number of subarraus with atmost (k-1) distinct elements. These will include subarrays with [1 .. (k-1)] distinct elements.
 * 3. (Number from 1. - Number from 2.) is an answer!
 */
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private Integer atMost(int[] nums, int k) {
        if(k==0) {
            return 0;
        }
        Map<Integer, Integer> numbersMap = new HashMap<>();

        int counter = 0;
        int windowStartIndex = 0;

        for (int windowEndIndex = 0; windowEndIndex < nums.length; windowEndIndex++) {
            numbersMap.merge(nums[windowEndIndex], 1, (o, n) -> o + 1);

            while (numbersMap.keySet().size() > k) {
                numbersMap.computeIfPresent(nums[windowStartIndex], (key, v) -> v == 1 ? null : v - 1);
                windowStartIndex++;
            }
            counter += windowEndIndex - windowStartIndex + 1;
        }
        return counter;
    }

    @Test
    public void test() {
        assertEquals(7, subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        assertEquals(10, subarraysWithKDistinct(new int[]{2,1,2,1,2}, 2));
        assertEquals(8, subarraysWithKDistinct(new int[]{2,1,1,1,2}, 1));
    }
}
