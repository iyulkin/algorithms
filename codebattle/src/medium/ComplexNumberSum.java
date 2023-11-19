package medium;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexNumberSum {

    @Test
    public void test() {
        assertEquals(List.of(4,-3), solution(List.of(1,-2), List.of(3,-1)));
        assertEquals(List.of(-1,3), solution(List.of(-3,2), List.of(2,1)));
    }

    private List<Integer> solution(List<Integer> first, List<Integer> second) {
        List<Integer> res = new ArrayList();
        res.add(first.get(0) + second.get(0));
        res.add(first.get(1) - second.get(1));
        return res;
    }
}
