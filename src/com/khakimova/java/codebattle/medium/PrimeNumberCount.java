package com.khakimova.java.codebattle.medium;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create a function that finds how many prime numbers are in a sequence from zero to a given integer, inclusive.
 */
public class PrimeNumberCount {

    @Test
    public void test() {
        assertEquals(0, solution(0));
        assertEquals(4, solution(10));
        assertEquals(9, solution(25));
        assertEquals(25, solution(100));
    }

    public Integer solution(Integer number) {
        return (int) IntStream.range(0, number + 1).filter(this::isPrime).count();
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
