package com.khakimova.java.easy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class PascalsTriangle2 {

    @Test
    public void test() {
        assertEquals(List.of(1, 3, 3, 1), getRow(3));
        assertEquals(List.of(1), getRow(0));
        assertEquals(List.of(1, 1), getRow(1));
    }

    private List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        row[0] = 1;
        row[rowIndex] = 1;
        for(int i = 1; i <= rowIndex/2; i++) {
            row[i] = (int)((long) row[i - 1] * (rowIndex + 1 - i) / i);
            row[rowIndex - i] = row[i];
        }
        return Arrays.asList(row);
    }
}
