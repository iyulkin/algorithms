package com.khakimova.java.codebattle.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create a function based on the input and output. Look at the examples, there is a pattern.
 * First number in range [1, 7], second in [0 8]. Operations pow, * and - can be helpful.
 */
public class SecretFunction {

    @Test
    public void test() {
        assertEquals(8, solution(2, 4));
        assertEquals(8, solution(4, 2));
        assertEquals(-4, solution(1, 5));
        assertEquals(15, solution(5, 2));
        assertEquals(322, solution(7, 3));
    }

    public Integer solution(Integer first, Integer second) {
        return (int) Math.pow((double) first, (double) second)
                - first * second;
    }
}
