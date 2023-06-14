package com.khakimova.java.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numberOfIslands = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    markIslandAsVisited(grid, i, j);
                    numberOfIslands++;
                }
            }
        return numberOfIslands;
    }

    private void markIslandAsVisited(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int[][] adjacents = new int[][]{{i, j - 1}, {i, j + 1}, {i - 1, j}, {i + 1, j}};

        for (int a = 0; a < adjacents.length; a++) {
            int x = adjacents[a][0];
            int y = adjacents[a][1];
            if (0 <= x && x < grid.length && 0 <= y && y < grid[0].length && grid[x][y] == '1') {
                markIslandAsVisited(grid, x, y);
            }
        }
    }

    @Test
    public void numIslandsTest() {
        assertEquals(1, numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }
}
