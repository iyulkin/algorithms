package com.khakimova.java.easy;

import java.util.LinkedList;
import java.util.Queue;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 */
public class FloodFill {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        if (color == currentColor) {
            return image;
        }
//        bfs(image, sr, sc, currentColor, color);
        dfs(image, sr, sc, currentColor, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int currentColor, int newColor) {
        int n = image.length;
        int m = image[0].length;
        if (0 <= sr && sr < n && 0 <= sc && sc < m && image[sr][sc] == currentColor) {
            image[sr][sc] = newColor;
            for(int[] d : directions) {
                dfs(image, sr + d[0], sc + d[1], currentColor, newColor);
            }
        }
    }

    private void bfs(int[][] image, int sr, int sc, int currentColor, int newColor) {

        Queue<int[]> nextToVisit = new LinkedList<>();
        int n = image.length;
        int m = image[0].length;
        nextToVisit.add(new int[]{sr, sc});

        while (!nextToVisit.isEmpty()) {
            int[] pixelIndex = nextToVisit.poll();
            int row = pixelIndex[0];
            int col = pixelIndex[1];
            if (0 <= row && row < n && 0 <= col && col < m && image[row][col] == currentColor) {
                image[row][col] = newColor;
                for (int[] d : directions) {
                    nextToVisit.add(new int[]{row + d[0], col + d[1]});
                }
            }
        }
    }

    @Test
    public void test() {
        //Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
        //Output: [[2,2,2],[2,2,0],[2,0,1]]
        assertThat(floodFill(new int[][]{{0, 0, 1}, {1, 0, 0}}, 1, 0, 2),
                is(new int[][]{{0, 0, 1}, {2, 0, 0}}));
        assertThat(floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2),
                is(new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}}));
    }
}
