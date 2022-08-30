package com.khakimova.java.medium;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
public class RotateImage {

    public int[][] rotate(int[][] matrix) {
        int length = matrix.length;
        int left = 0, top = 0, right = length - 1, bottom = length - 1;
        while (left < right && top < bottom) {
            for (int i = 0; i < right - left; i++) {
                int first = matrix[top][left + i];
                int second = matrix[top + i][right];
                int third = matrix[bottom][right - i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[top + i][right] = first;
                matrix[bottom][right - i] = second;
                matrix[bottom - i][left] = third;
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return matrix;
    }

    @Test
    public void test() {
        // matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //Output: [[7,4,1],[8,5,2],[9,6,3]]
        assertArrayEquals(new int[][]{{7,4,1}, {8,5,2}, {9,6,3}}, rotate(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}}));
    }
}
