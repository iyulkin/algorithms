package com.khakimova.java.yandex;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Дан массив целых чисел. Найти минимальное произведение пары значений из заданного массива.
 * <p>
 * {9,4,6,7,1,2,3} -> 2
 * {6,4,0,-9,5,1} -> -54
 * {-3,-5,-9,-2,-6} -> 6
 */
public class MinPairMultiplication {

    @Test
    public void test() {
        assertEquals(2, minPairMultiplication(new int[]{9, 4, 6, 7, 1, 2, 3}));
        assertEquals(-54, minPairMultiplication(new int[]{6, 4, 0, -9, 5, 1}));
        assertEquals(6, minPairMultiplication(new int[]{-3, -5, -9, -2, -6}));
        assertEquals(21, minPairMultiplication(new int[]{7, 3}));
        assertThrows(IllegalArgumentException.class, () -> minPairMultiplication(null));
        assertThrows(IllegalArgumentException.class, () -> minPairMultiplication(new int[]{3}));
    }

    /*
    1. Предлагается отсортировать массив по возрастанию элементов
    Сложность: O(n*log(n))

    2. Предлагается найти 2 минимальных и 2 максимальных элемента массива за 1 проход. {min0, min1 ... max0, max1}
    Сложность: O(n)

    Если крайние числа положительные, вернуть произведение двух минимальных элементов.
    Если крайние числа отрицательные, вернуть произведение двух максимальных элементов.
    Если крайние числа разных знаков, вернуть произведение крайних элементов.
     */
    private int minPairMultiplication(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Array's length must be more than 1");
        }
        Arrays.sort(numbers);
        int n = numbers.length;

        if (numbers[0] >= 0) {
            return numbers[0] * numbers[1];
        }
        if (numbers[n-1] < 0) {
            return numbers[n-1] * numbers[n-2];
        }
        return numbers[0] * numbers[n-1];
    }
}
