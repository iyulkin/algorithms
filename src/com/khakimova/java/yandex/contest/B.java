package com.khakimova.java.yandex.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/*
Лента фотографий 50 баллов

Для разработки модуля отображения фотографий в виде вертикальной ленты решено использовать следующий алгоритм:

- выбрать k фотографий из имеющейся коллекции;
- отмасштабировать все фотографии до ширины w;
- отображать полученные фотографии в вертикальном формате одна над одной без отступов.

Определите, какую наибольшую и наименьшую высоту может иметь полученная лента из k фотографий.

Будем считать, что при масштабировании фотографии размера w' x ℎ' до ширины w, новая высота вычисляется по следующей формуле:
ℎ = Потолок(h' * w / w')
 */
public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int w = Integer.parseInt(reader.readLine());
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] dimentions = new int[n][2];

        for(int i=0; i<n; i++) {
            String[] dimention = reader.readLine().split("x");
            dimentions[i][0] = Integer.parseInt(dimention[0]);
            dimentions[i][1] = Integer.parseInt(dimention[1]);
        }

        int[] result = calculateMinAndMax(w, k, dimentions);
        writer.write(String.valueOf(result[0]));
        writer.newLine();
        writer.write(String.valueOf(result[1]));

        reader.close();
        writer.close();
    }

    @Test
    public void test() {
        assertThat(calculateMinAndMax(2000, 3, new int[][]{
                {1000, 1000},
                {1000, 1500},
                {640, 930},
                {640, 1500},
                {3000, 1000},
        }), is(new int[]{5574, 10595}));

        assertThat(calculateMinAndMax(1000, 5, new int[][]{
                {1404, 1386},
                {1132, 1110},
                {1061, 1801},
                {1022, 1519},
                {1529, 1003},
        }), is(new int[]{5810, 5810}));

        assertThat(calculateMinAndMax(4096, 1, new int[][]{
                {640, 4096},
                {4096, 640}
        }), is(new int[]{640, 26215}));
    }

    private static int[] calculateMinAndMax(int w, int k, int[][] dimensions) {
        int n = dimensions.length;
        int[] hArray = new int[n];

        // вычислить новые значения h
        // отсортировать массив, найти суммы k минимальных и k максимальных h
        // сложность: O(log(n))

        for(int i = 0; i < n; i++) {
            hArray[i] = (int) Math.ceil(1.0 * dimensions[i][1] * w / dimensions[i][0]);
        }

        Arrays.sort(hArray);
        int min = 0;
        int max = 0;

        for(int i = 0; i < k; i++) {
            min += hArray[i];
            max += hArray[n - 1 - i];
        }

        return new int[]{min, max};
//        int[] result = new int[2];
//
//        // За один проход по массиву dimensions определить k минимальных и k максимальных h,
//        // получаемых в процессе масштабирования
//        // Сложность: O(n)
//        int[] min = new int[k];
//        int[] max = new int[k];
//
//        for (int i = 0; i < k; i++) {
//            min[i] = 27000;
//            max[i] = 600;
//        }
//
//        for (int i = 0; i < dimensions.length; i++) {
//            int h = (int) Math.ceil((double) dimensions[i][1] * w / dimensions[i][0]);
//            findPlace(min, h, 1);
//            findPlace(max, h, -1);
//        }
//
//        for (int i = 0; i < k; i++) {
//            result[0] += min[i];
//            result[1] += max[i];
//        }
//
//        return result;
    }

    private static void findPlace(int[] array, int h, int direction) {
        boolean placeFound = false;
        int j = 0;

        while (!placeFound && j < array.length) {
            if (h * direction < array[j] * direction) {
                moveRight(array, j);
                array[j] = h;
                placeFound = true;
            } else {
                j++;
            }
        }
    }

    private static void moveRight(int[] array, int start) {
        for (int i = array.length - 1; i > start; i--) {
            array[i] = array[i - 1];
        }
    }
}
