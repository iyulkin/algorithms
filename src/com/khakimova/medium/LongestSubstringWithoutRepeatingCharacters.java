package com.khakimova.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        String[] array = s.split("");
        Map<String, Integer> charactersMap = new HashMap<>();

        int result = 0;
        int windowStartIndex = 0;
        int currentWindowLength;

        for (int windowEndIndex = 0; windowEndIndex < array.length; windowEndIndex++) {
            String character = array[windowEndIndex];

            // increase the window
            charactersMap.merge(character, 1, (o, n) -> o + 1);
            currentWindowLength = windowEndIndex - windowStartIndex + 1;
            while (currentWindowLength > charactersMap.keySet().size()) {
                // decrease the window
                charactersMap.computeIfPresent(array[windowStartIndex], (k, v) -> v == 1 ? null : v - 1);
                windowStartIndex++;
                currentWindowLength--;
            }
            // save the result if current window is larger
            result = Math.max(result, currentWindowLength);
        }
        return result;
    }

    @Test
    public void test() {
        assertEquals(0, lengthOfLongestSubstring(""));
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
}
