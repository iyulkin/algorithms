package hard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountAndSay {

    @Test
    public void test() {
        assertEquals("111221", solution("three 1, then two 2's, then one 1"));
        assertEquals("11", solution("two 1's"));
        assertEquals("21", solution("one 2, then one 1"));
    }

    private final Pattern DIGIT_PATTERN = Pattern.compile("\\d");

    private String solution(String str) {
        String res = "";
        String[] parts = str.split(",");
        for (int i = 0; i < parts.length; i++) {
            Matcher m = DIGIT_PATTERN.matcher(parts[i]);
            if (m.find()) {
                String n = m.group();
                for (int j = 0; j < cnt(parts[i]); j++) {
                    res = res + n;
                }
            }
        }
        return res;
    }

    private int cnt(String s) {
        if (s.contains("one")) {
            return 1;
        } else if (s.contains("two")) {
            return 2;
        } else if (s.contains("three")) {
            return 3;
        } else if (s.contains("four")) {
            return 4;
        } else if (s.contains("five")) {
            return 5;
        } else if (s.contains("six")) {
            return 6;
        } else if (s.contains("seven")) {
            return 7;
        } else if (s.contains("eight")) {
            return 8;
        } else if (s.contains("nine")) {
            return 9;
        }
        return 0;
    }


}
