package com.khakimova.java.yandex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
 * <p>
 * Желательно получить решение, работающее за линейное время и при этом проходящее по входному массиву только один раз.
 */
public class MaxSequence {

    @Test
    public void test() {
        assertThat(0, equalTo(maxSequence(null)));
        assertThat(1, equalTo(maxSequence(new int[]{1,0,1,0,1})));
        assertThat(3, equalTo(maxSequence(new int[]{1,1,1})));
        assertThat(0, equalTo(maxSequence(new int[]{0,0,0})));
        assertThat(3, equalTo(maxSequence(new int[]{1,0,0,1,1,1})));
        assertThat(3, equalTo(maxSequence(new int[]{1,0,1,1,1,0})));
        assertThat(2, equalTo(maxSequence(new int[]{1,1,0,1,0})));
    }

    private int maxSequence(int[] input) {
        if (input == null || input.length < 2) {
            return 0;
        }
        int max = 0;
        int cur = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 1) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 0;
            }
        }

        return max;
    }
}
