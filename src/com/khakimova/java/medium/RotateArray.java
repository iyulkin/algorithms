package com.khakimova.java.medium;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        if (k > 0) {
            int[] rotated = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                rotated[(i + k) % nums.length] = nums[i];
            }
            for(int i = 0; i<nums.length; i++) {
                nums[i] = rotated[i];
            }
        }
    }

    public int[] rotate(int[] nums, int k) {
        k = k % nums.length;

        if (k > 0) {
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        return nums;
    }

    private void reverse(int[] nums, int leftIndex, int rightIndex) {
        while (leftIndex < rightIndex) {
            int valueAtLeftIndex = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = valueAtLeftIndex;
            leftIndex++;
            rightIndex--;
        }
    }

    @Test
    public void rotateTest() {
        assertArrayEquals(new int[]{5, 6, 7, 1, 2, 3, 4}, rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3));
        assertArrayEquals(new int[]{3, 99, -1, -100}, rotate(new int[]{-1, -100, 3, 99}, 2));
    }
}
