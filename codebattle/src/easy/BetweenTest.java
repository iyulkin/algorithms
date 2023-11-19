package easy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Write function that returns subtext from text between given patterns.
 */
public class BetweenTest {
    @Test
    public void test() {
        Assertions.assertEquals("foo", solution("<a>foo</a>", "<a>", "</a>"));
        Assertions.assertEquals("text", solution("this is 'text'", "'", "'"));
    }

    public String solution(String str, String left, String right) {
        int leftInd = str.indexOf(left);
        if (leftInd < 0) {
            return "";
        }
        leftInd += left.length();
        int rightInd = str.lastIndexOf(right);
        if (rightInd < 0) {
            return "";
        }
        return str.substring(leftInd, rightInd);
    }
}
