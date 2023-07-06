package com.khakimova.java.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LetterCombinationsOfAPhoneNumber {


    @Test
    public void test() {
        assertEquals(List.of("a", "b", "c"), letterCombinations("2"));
    }

    private Map<Character, List<String>> map;
    private List<String> result;

    private void init() {
        result = new ArrayList();

        map = new HashMap();
        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || !digits.matches("[2-9]+")) {
            return Collections.emptyList();
        }
        init();
        combinations("", digits, 0, digits.length());
        return result;
    }

    private void combinations(String str, String digits, int i, int length) {
        if (str.length() == length) {
            result.add(str);
        } else {
            List<String> list = map.getOrDefault(digits.charAt(i), Collections.emptyList());
            for (String s : list) {
                combinations(str + s, digits, i + 1, length);
            }
        }
    }
}
