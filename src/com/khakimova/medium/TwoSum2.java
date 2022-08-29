package com.khakimova.medium;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * <p>
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * <p>
 * Your solution must use only constant extra space.
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        // binary search
        int leftIndex = 0, rightIndex = numbers.length-1, middleIndex, sum;

        for (int i = 0; i < numbers.length; i++) {
            leftIndex = i+1;
            while (leftIndex <= rightIndex) {
                middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
                sum = numbers[i] + numbers[middleIndex];
                if (sum == target) {
                    return new int[]{i + 1, middleIndex + 1};
                }
                if (sum < target) {
                    leftIndex = middleIndex + 1;
                } else {
                    rightIndex = middleIndex - 1;
                }
            }
        }
        return new int[2];
    }

    public int[] twoSumTwoPoints(int[] numbers, int target) {
        // two points
        int leftIndex = 0, rightIndex = numbers.length - 1;
        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];
            if (sum == target) {
                return new int[]{leftIndex + 1, rightIndex + 1};
            }
            if (sum < target) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return new int[2];
    }

    public int[] twoSumBruteForce(int[] numbers, int target) {
        // brute force
        HashMap<Integer, Integer> numbersMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer index1 = numbersMap.get(target - numbers[i]);
            if (index1 != null) {
                return new int[]{index1, i + 1};
            } else {
                numbersMap.put(numbers[i], i + 1);
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void twoSumTest() {
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, twoSum(new int[]{2, 3, 4}, 6));
        assertArrayEquals(new int[]{1, 2}, twoSum(new int[]{-1, 0}, -1));
    }
}
