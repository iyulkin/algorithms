package com.khakimova.java.easy;

/**
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 * <p>
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length; // rows
        int n = matrix[0].length; //cols
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] != matrix[row - 1][col - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
