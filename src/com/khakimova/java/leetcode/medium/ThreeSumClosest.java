package com.khakimova.java.leetcode.medium;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {

    @Test
    public void test() {
        assertEquals(2, threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        assertEquals(0, threeSumClosest(new int[]{0, 0, 0, 0}, 1));
    }

    private int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) {
                    return sum;
                }
                if(Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
