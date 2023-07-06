package com.khakimova.java.leetcode.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcelSheetColumnNumber {

    @Test
    public void test() {
        assertEquals(1, titleToNumber("A"));
        assertEquals(28, titleToNumber("AB"));
    }

    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, n - i - 1);
        }
        return res;
    }
}
