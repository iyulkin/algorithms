package com.khakimova.java.codebattle.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaVolume {

    @Test
    public void test() {
        assertEquals(3, solution(1, 1));
        assertEquals(308, solution(7, 2));
        assertEquals(942, solution(10, 3));
    }

    public Integer solution(Integer radius, Integer height) {
        return (int) Math.round(Math.PI * radius * radius * height);
    }
}
