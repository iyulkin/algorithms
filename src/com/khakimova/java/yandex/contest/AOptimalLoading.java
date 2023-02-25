package com.khakimova.java.yandex.contest;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Оптимальная погрузка 50 баллов

Ящики нужно доставить.
Имеется N10 ящиков по 10 кг и N50  ящиков по 50 кг, а также M грузовиков, пронумерованных от 1 до M.
Грузоподъёмность ограничена: грузовик с номером i может везти не более G(i) килограммов.

Найдите минимальное число грузовиков, необходимое для доставки всех имеющихся ящиков за один раз, или определите, что это невозможно.
 */
public class AOptimalLoading {

    public static void main(String[] args) throws IOException {
        assertEquals(1, calculate(new int[]{5, 0}, new int[]{10, 52, 42, 11}));
        assertEquals(-1, calculate(new int[]{0, 1}, new int[]{49}));
        assertEquals(0, calculate(new int[]{0, 0}, new int[]{49}));
        assertEquals(1, calculate(new int[]{2, 1}, new int[]{81, 40}));
        assertEquals(2, calculate(new int[]{2, 1}, new int[]{10, 52, 42, 11}));
        assertEquals(4, calculate(new int[]{13, 0}, new int[]{42, 47, 40, 49, 42}));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

//        String[] parts = reader.readLine().split(" ");
//        int[] boxes = new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};
//        int m = Integer.parseInt(parts[2]);
//        int[] trucks = new int[m];
//
//        parts = reader.readLine().split(" ");
//        for (int i = 0; i < trucks.length; i++) {
//            trucks[i] = Integer.parseInt(parts[i]);
//        }
//
//        int result = calculate(boxes, trucks);
//        writer.write(String.valueOf(result));

//        reader.close();
//        writer.close();
    }

    private static int calculate(int[] boxes, int[] trucks) {
        if(boxes[0] == 0 && boxes[1] == 0) {
            return 0;
        }

        int minTrucksAmount = 0;
        Arrays.sort(trucks);

        for (int i = trucks.length - 1; i > -1; i--) {
            int truck = trucks[i];
            boolean used = false;

            if (boxes[1] > 0) {
                if(truck < 50) {
                    return -1;
                }
                int n50 = Math.min(boxes[1], truck / 50);
                boxes[1] -=  n50;
                truck -= n50 * 50;
                used = true;
            }
            if (boxes[0] > 0 && truck > 10) {
                int n10 = Math.min(boxes[0], truck / 10);
                boxes[0] -= n10;
                used = true;
            }
            if (used) {
                minTrucksAmount++;
            } else {
                break;
            }
        }

        if (boxes[0] > 0 || boxes[1] > 0) {
            return -1;
        }

        return minTrucksAmount;
    }
}
