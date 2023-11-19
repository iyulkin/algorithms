package easy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * For each element X of the given array, count how many elements to the right of X are smaller than X.
 * The last value is always zero since there are no elements to the right of the last element.
 */
public class CountSmallerElementsOnRightSide {

    @Test
    public void test() {
        assertEquals(List.of(6,1,1,1,0,1,0), solution(List.of(12,1,2,3,0,11,4)));
    }

    public List<Integer> solution(List<Integer> arr) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < arr.size(); i++) {
            int current = arr.get(i);
            result.add((int) arr.stream().skip(i).filter(e -> e < current).count());
        }
        return result;
    }
}
