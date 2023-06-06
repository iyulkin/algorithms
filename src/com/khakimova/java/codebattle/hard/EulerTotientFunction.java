package com.khakimova.java.codebattle.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EulerTotientFunction {
    @Test
    public void test() {
        assertEquals(1, solution(1));
        assertEquals(4, solution(10));
        assertEquals(16, solution(40));
        assertEquals(60, solution(99));
    }

    private Integer solution(Integer num) {
        if (num == 1) {
            return 1;
        }
        int x = num - 1;
        int res = 0;
        while (x > 0) {
            if (nod(num, x) == 1) {
                res++;
            }
            x--;
        }
        return res;
    }

    private Integer nod(Integer n1, Integer n2) {
        int x = n1 % n2;
        if (n1 >= n2 && x == 0) {
            return n2;
        } else {
            return nod(n2, x);
        }
    }
}
