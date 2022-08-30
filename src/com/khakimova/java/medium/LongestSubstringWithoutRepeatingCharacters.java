package com.khakimova.java.medium;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> charactersSet = new HashSet<>();
        int resultLength = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        while (rightPointer < s.length()) {
            if(!charactersSet.add(s.charAt(rightPointer))) {
                while (s.charAt(rightPointer) != s.charAt(leftPointer)) {
                    charactersSet.remove(s.charAt(leftPointer));
                    leftPointer++;
                }
                leftPointer++;
            }
            if(charactersSet.size() > resultLength) {
                resultLength = charactersSet.size();
            }
            rightPointer++;
        }
        return resultLength;
    }

    @Test
    public void test() {
        assertEquals(2, lengthOfLongestSubstring("abba"));
        assertEquals(0, lengthOfLongestSubstring(""));
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }
}
