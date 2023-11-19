package easy;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheBigDivide {

    @Test
    public void test() {
        assertEquals(23, solution(10, 3, 5));
        assertEquals(0, solution(3, 17, 11));
    }

    public Integer solution(Integer n, Integer a, Integer b) {
        return IntStream.range(1, n).filter(x -> x % a == 0 || x % b == 0).sum();
    }
}
