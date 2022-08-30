package com.khakimova.java.medium;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        } else {
            List<StringBuilder> rows = IntStream.range(0, numRows).mapToObj(StringBuilder::new).collect(Collectors.toList());
            int curRow = 0;
            int direction = 1;
            for (int i = 0; i < s.length(); i++) {
                rows.get(curRow).append(s.charAt(i));
                if (curRow == numRows - 1) {
                    direction = -1;
                } else if(curRow == 0) {
                    direction = 1;
                }
                curRow = curRow + direction;
            }
            return rows.stream().map(StringBuilder::toString).collect(Collectors.joining());
        }
    }

    @Test
    public void zigzagConversionTest() {
        assertEquals("PAYPALISHIRING", convert("PAYPALISHIRING", 1));
        assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));
    }
}
