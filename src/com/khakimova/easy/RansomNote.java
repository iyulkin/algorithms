package com.khakimova.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Integer> magazineMap = new HashMap<>();
        String[] magazineArray = magazine.split("");
        String[] noteArray = ransomNote.split("");

        for (String ch : magazineArray) {
            magazineMap.compute(ch, (k, v) -> (v == null) ? 1 : v + 1);
        }
        for (String ch : noteArray) {
            if (magazineMap.containsKey(ch)) {
                magazineMap.compute(ch, (k, v) -> (v == 1) ? null : v - 1);
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        int[] charsCountArray = new int[26];
        for (char ch : magazine.toCharArray()) {
            charsCountArray[ch - 'a']++;
        }
        for (char ch : ransomNote.toCharArray()) {
            if (charsCountArray[ch - 'a'] > 0) {
                charsCountArray[ch - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void canConstructTest() {
        assertTrue(canConstruct("aa", "aab"));
        assertTrue(canConstruct("rat", "abtar"));
        assertFalse(canConstruct("a", "b"));
    }

    @Test
    public void canConstruct2Test() {
        assertTrue(canConstruct2("aa", "aab"));
        assertTrue(canConstruct2("rat", "abtar"));
        assertFalse(canConstruct2("a", "b"));
    }
}

