package com.khakimova.java.codebattle.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExcelSheetColumnTitle {

    @Test
    public void test() {
        assertEquals("A", solution(1));
        assertEquals("Z", solution(26));
        assertEquals("YP", solution(666));
        assertEquals("AJHX", solution(24568));
    }

    public String solution(Integer num) {
        StringBuilder builder = new StringBuilder();
        if(num < 27) {
            builder.append((char)('A' + num - 1));
        } else {
            builder.append(solution(num / 26)).append(solution(num % 26));
        }
        return builder.toString();
    }
}
