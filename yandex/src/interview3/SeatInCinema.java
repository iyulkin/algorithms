package interview3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

////////////////////////////////////////////
// один ряд, хотя бы одно занято, хотя бы одно свободно

// Напишите функцию, которая по заданному ряду мест (массиву из нулей и единиц)
// вернёт максимально достижимое расстояние от выбранного места до ближайшего зрителя.
// расстояние до соседнего кресла = 1

public class SeatInCinema {

    @Test
    void test() {
        assertEquals(2, findBestSeatDist(new int[]{1, 0, 0, 0, 1}));
        assertEquals(2, findBestSeatDist(new int[]{1, 0, 0, 0, 0, 1}));
        assertEquals(1, findBestSeatDist(new int[]{1, 0, 1, 0, 0, 1}));
        assertEquals(3, findBestSeatDist(new int[]{1, 0, 0, 0}));
        assertEquals(2, findBestSeatDist(new int[]{0, 0, 1}));
    }

    int findBestSeatDist(int[] sits) {
        if(sits == null || sits.length < 2) {
            throw new IllegalArgumentException();
        }

        int n = sits.length;
        int distance = 0;
        int result = 0;
        int left = 0;

        while(left < n) {
            if(sits[left] == 0) {
                int right = left + 1;
                while(right < n && sits[right] == 0) {
                    right ++;
                }
                right--;
                if(left == 0 || right == n-1) {
                    distance = right - left + 1;
                } else {
                    distance = (right - left)/2 + 1;
                }
                result = Math.max(result, distance);
                left = right + 1;
            } else {
                left ++;
            }
        }
        return result;
    }
}

