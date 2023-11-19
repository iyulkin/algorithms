package easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationSuggestion {

    @Test
    public void test() {
        assertEquals("addition", solution(10, 12, 22));
        assertEquals("subtraction", solution(10, 5, 5));
        assertEquals("multiplication", solution(10, 2, 20));
    }

    public String solution(Integer first, Integer second, Integer result) {
        if(first + second == result) {
            return "addition";
        }
        if(first - second == result) {
            return "subtraction";
        }
        if(first * second == result) {
            return "multiplication";
        }
        return "unrecognized operation!!";
    }
}
