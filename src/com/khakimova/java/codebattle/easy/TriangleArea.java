package com.khakimova.java.codebattle.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleArea {

    @Test
    public void test() {
        assertEquals(216, solution(24, 30, 18));
    }

    public Integer solution(Integer a, Integer b, Integer c) {
        Double p = (double) (a + b + c) / 2;
        return (int) Math.floor(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}
