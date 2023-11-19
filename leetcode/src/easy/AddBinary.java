package easy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinary {

    @Test
    public void test() {
        assertEquals("100", addBinary("11", "1"));
        assertEquals("10101", addBinary("1010", "1011"));
    }

    private String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        while (i >= 0 || j >= 0) {
            int sum = c;
            if(i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            c = sum / 2;
            result.append(sum % 2);
        }
        if(c > 0) {
            result.append(c);
        }
        return result.reverse().toString();
    }
}
