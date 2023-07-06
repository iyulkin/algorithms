package com.khakimova.java.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0, finish = nums.length, medium;

        while (start < finish) {
            medium = start + (finish - start) / 2;
            if (nums[medium] == target) {
                return medium;
            }
            if (finish - start < 2) {
                return -1;
            }
            if (nums[medium] > target) {
                finish = medium;
            } else {
                start = medium;
            }
        }
        return -1;
    }

    @Test
    public void searchTest() {
        assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        assertEquals(0, search(new int[]{5},5));
    }
}
