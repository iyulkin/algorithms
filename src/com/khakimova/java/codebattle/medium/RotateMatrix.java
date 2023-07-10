package com.khakimova.java.codebattle.medium;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Implement a function that rotates matrix.
 */
public class RotateMatrix {

    @Test
    public void test() {
        assertEquals(List.of(List.of(1, 4), List.of(2, 5), List.of(3, 6)), solution(List.of(List.of(1, 2, 3), List.of(4, 5, 6))));
    }

    public List<List<Integer>> solution(List<List<Integer>> matrix) {
        List<List<Integer>> res = new ArrayList();
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        for (int i = 0; i < cols; i++) {
            List<Integer> row = new ArrayList();
            for (int j = 0; j < rows; j++) {
                row.add(matrix.get(j).get(i));
            }
            res.add(row);
        }
        return res;
    }
}
