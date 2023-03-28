package com.khakimova.java.easy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class PascalsTriangle {

    @Test
    public void test() {
        assertEquals(List.of(
                List.of(1),
                List.of(1,1),
                List.of(1, 2, 1),
                List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1)
                ), generate(5));
        assertEquals(List.of(List.of(1)), generate(1));
    }

    private List<List<Integer>> generate(int numRows) {
        List<Integer> lastRow = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

        if(numRows == 1) {
            lastRow.add(1);
        } else {
            list.addAll(generate(numRows - 1));
            List<Integer> prevRow = list.get(list.size() - 1);
            lastRow.add(1);
            for(int i = 0; i < prevRow.size() - 1; i++) {
                lastRow.add(prevRow.get(i) + prevRow.get(i + 1));
            }
            lastRow.add(1);
        }
        list.add(lastRow);

        return list;
    }
}
