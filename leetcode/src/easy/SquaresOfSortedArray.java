package easy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int leftPointer = 0, rightPointer = nums.length - 1;
        int squareAtLeftPointer, squareAtRightPointer;
        int[] sortedSquares = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            squareAtLeftPointer = nums[leftPointer] * nums[leftPointer];
            squareAtRightPointer = nums[rightPointer] * nums[rightPointer];

            if (squareAtLeftPointer > squareAtRightPointer) {
                sortedSquares[i] = squareAtLeftPointer;
                leftPointer++;
            } else {
                sortedSquares[i] = squareAtRightPointer;
                rightPointer--;
            }
        }
        return sortedSquares;
    }

    @Test
    public void sortedSquaresTest() {
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, sortedSquares(new int[]{-4, -1, 0, 3, 10}));
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }
}
