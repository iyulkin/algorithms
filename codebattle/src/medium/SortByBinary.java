package medium;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Sort an array of integers by the number of 1's in its binary representation (in ascending order).
 * If two integers have the same number of 1's in their binary representation, their relative order should be the same as in the original array.
 */
public class SortByBinary {

    @Test
    public void test() {
        assertEquals(List.of(1, 2, 4, 3), solution(List.of(1, 2, 3, 4)));
        assertEquals(List.of(8, 9, 6, 7), solution(List.of(9, 8, 7, 6)));
    }

    public List<Integer> solution(List<Integer> arr) {
        return arr.stream().sorted(Comparator.comparing(
                x -> Integer.toBinaryString(x.intValue()).replaceAll("0", "").length()
        )).collect(Collectors.toList());
    }
}
