package easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    @Test
    public void test() {
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
    }

    private int climbStairs(int n) {
        if(n < 3) {
            return n;
        }
        int memo1 = 1;
        int memo2 = 2;
        for(int i = 2; i < n; i++) {
            int tmp = memo1 + memo2;
            memo1 = memo2;
            memo2 = tmp;
        }
        return memo2;
    }
}
