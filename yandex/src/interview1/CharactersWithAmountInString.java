package interview1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Дана строка, состоящая из заглавных букв латинского алфавита AAABBGGGHJAAAAKKKKKKL или пустая
 * Вернуть строку вида A3B2G3HJA4K6L
 * Генерировать исключение при некорректной строке
 */
public class CharactersWithAmountInString {

    public static void main(String[] args) {
        assertEquals("A3B2G3HJA4K6L", modify("AAABBGGGHJAAAAKKKKKKL"));
        assertEquals("", modify(""));
        assertThrows(IllegalArgumentException.class, () -> modify(null));
    }

    private static String modify(String s) throws IllegalArgumentException {
        if(!isCorrect(s)) {
            throw new IllegalArgumentException("Argument doesn't match the pattern");
        }
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            builder.append(s.charAt(i));
            int j = i + 1;
            while(j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            if(j - i > 1) {
                builder.append(j - i);
            }
            i = j;
        }
        return builder.toString();
    }

    private static boolean isCorrect(String s) {
        return s != null && s.matches("^[A-Z]*$");
    }
}
