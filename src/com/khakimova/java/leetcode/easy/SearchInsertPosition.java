package com.khakimova.java.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/search-insert-position/
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, finish = nums.length, medium;

        while (start < finish) {
            medium = start + (finish - start) / 2;
            if (nums[medium] == target) {
                return medium;
            }
            if(nums[medium] > target){
                if(medium == 0) {
                    return 0;
                } else {
                    finish = medium;
                }
            } else {
                start = medium + 1;
            }
        }
        return start;
    }

    @Test
    public void searchInsertTest() {
        assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
        assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
        assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));
        assertEquals(0, searchInsert(new int[]{1,3,5,6}, 0));
    }
}
