package com.khakimova.java.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {

    @Test
    public void test() {
        assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        assertEquals(Collections.emptyList(), threeSum(new int[]{0, 1, 1}));
        assertEquals(List.of(List.of(0, 0, 0)), threeSum(new int[]{0, 0, 0}));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet();
        Arrays.sort(nums);

        for(int i = 0;  i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                }
                if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return List.copyOf(result);
    }
}
