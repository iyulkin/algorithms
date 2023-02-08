package com.khakimova.java.medium;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
 * <p>
 * Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.
 * <p>
 * A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
 * A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
 * We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.
 * <p>
 * Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.
 */
public class WhereWillTheBallFall {

    @Test
    public void test() {
        assertThat(findBall(new int[][]{
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        }), equalTo(new int[]{1, -1, -1, -1, -1}));
    }

    public int[] findBall(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] result = new int[cols];

        for (int i = 0; i < cols; i++) {
            int x = i;
            int y = 0;
            while (y < rows && !gotStuck(grid, x, y)) {
                x += grid[y][x];
                y++;
            }
            if (y == rows) {
                result[i] = x;
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    private boolean gotStuck(int[][] grid, int x, int y) {
        return (x == 0 && grid[y][x] == -1)
                || (x == grid[0].length - 1 && grid[y][x] == 1)
                || (grid[y][x] == 1 && grid[y][x + 1] == -1)
                || (grid[y][x] == -1 && grid[y][x - 1] == 1);
    }

    public int[] findBallWithMemoization(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] path = new int[n][m];
        for (int r = n - 1; r >= 0; r--)
            for (int c = m - 1; c >= 0; c--) {
                int neighbor = c + grid[r][c];
                if (neighbor == -1 || neighbor == m
                        || (grid[r][neighbor] != grid[r][c])) {
                    path[r][c] = -1;
                } else {
                    if (r == n - 1) {
                        path[r][c] = neighbor;
                    } else {
                        path[r][c] = path[r + 1][neighbor];
                    }
                }
            }
        return path[0];
    }
}
