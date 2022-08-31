package com.khakimova.java.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * <p>
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * <p>
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 * <p>
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;

        Queue<int[]> atlanticQueue = new LinkedList<>();
        Queue<int[]> pacificQueue = new LinkedList<>();
        boolean[][] atlanticPaths = new boolean[n][m];
        boolean[][] pacificPaths = new boolean[n][m];

        for (int r = 0; r < n; r++) {
            atlanticQueue.add(new int[]{r, m - 1});
            atlanticPaths[r][m - 1] = true;
            pacificQueue.add(new int[]{r, 0});
            pacificPaths[r][0] = true;
        }
        for (int c = 0; c < m; c++) {
            atlanticQueue.add(new int[]{n - 1, c});
            atlanticPaths[n - 1][c] = true;
            pacificQueue.add(new int[]{0, c});
            pacificPaths[0][c] = true;
        }
        bfs(atlanticQueue, heights, atlanticPaths);
        bfs(pacificQueue, heights, pacificPaths);
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++)
                if (atlanticPaths[r][c] && pacificPaths[r][c])
                    result.add(List.of(r, c));

        return result;
    }

    private void bfs(Queue<int[]> queue, int[][] heights, boolean[][] hasPath) {
        int n = heights.length;
        int m = heights[0].length;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            hasPath[cell[0]][cell[1]] = true;

            for (int[] direction : directions) {
                int row = cell[0] + direction[0];
                int col = cell[1] + direction[1];
                if (0 <= row && row < n && 0 <= col && col < m
                        && !hasPath[row][col] && heights[row][col] >= heights[cell[0]][cell[1]]) {
                    queue.add(new int[]{row, col});
                }
            }
        }
    }


    @Test
    public void test() {
        assertThat(List.of(List.of(0, 4), List.of(1, 3), List.of(1, 4), List.of(2, 2), List.of(3, 0), List.of(3, 1), List.of(4, 0)),
                equalTo(pacificAtlantic(new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}})));
    }

    private boolean hasPathToAtlanticOcean(int[][] heights, int[][] paths, int r, int c) {
        if (paths[r][c] == 1 || paths[r][c] == 3) {
            return true;
        }
        if (r == heights.length - 1 || c == heights[0].length - 1
                || Stream.of(List.of(r - 1, c), List.of(r + 1, c), List.of(r, c - 1), List.of(r, c + 1))
                .filter(coordinate -> coordinate.get(0) >= 0 && coordinate.get(0) < heights.length
                        && coordinate.get(1) >= 0 && coordinate.get(1) < heights[0].length
                        && heights[coordinate.get(0)][coordinate.get(1)] <= heights[r][c])
                .anyMatch(coordinate -> hasPathToAtlanticOcean(heights, paths, coordinate.get(0), coordinate.get(1)))) {
            paths[r][c] += 1;
            return true;
        }
        return false;
    }

    private boolean hasPathToPacificOcean(int[][] heights, int[][] paths, int r, int c) {
        if (paths[r][c] == 2 || paths[r][c] == 3) {
            return true;
        }
        if (r == 0 || c == 0
                || Stream.of(List.of(r - 1, c), List.of(r + 1, c), List.of(r, c - 1), List.of(r, c + 1))
                .filter(coordinate -> coordinate.get(0) >= 0 && coordinate.get(0) < heights.length
                        && coordinate.get(1) >= 0 && coordinate.get(1) < heights[0].length
                        && heights[coordinate.get(0)][coordinate.get(1)] <= heights[r][c])
                .anyMatch(coordinate -> hasPathToPacificOcean(heights, paths, coordinate.get(0), coordinate.get(1)))) {
            paths[r][c] += 2;
            return true;
        }
        return false;
    }
}
