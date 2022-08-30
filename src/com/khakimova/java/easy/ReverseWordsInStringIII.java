package com.khakimova.java.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */
public class ReverseWordsInStringIII {

    public String reverseWords(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] characters = s.toCharArray();
        int wordStart = 0, wordEnd = 1;

        for (; wordEnd < characters.length; wordEnd++) {
            if (characters[wordEnd] == ' ') {
                reverseCharacters(characters, wordStart, wordEnd - 1);
                wordStart = ++wordEnd;
            }
        }
        reverseCharacters(characters, wordStart, characters.length - 1);
        return new String(characters);
    }

    private void reverseCharacters(char[] chars, int startPosition, int endPosition) {
        char leftCharacter;
        while (startPosition < endPosition) {
            leftCharacter = chars[startPosition];
            chars[startPosition] = chars[endPosition];
            chars[endPosition] = leftCharacter;
            startPosition++;
            endPosition--;
        }
    }

    public String reverseWords1(String s) {
        String[] wordsArray = s.split(" ");
        for (int i = 0; i < wordsArray.length; i++) {
            wordsArray[i] = reverseWorld1(wordsArray[i]);
        }
        return String.join(" ", wordsArray);
    }

    private String reverseWorld1(String s) {
        String[] characters = s.split("");
        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            if (!characters[left].equals(characters[right])) {
                String leftCharacter = characters[left];
                characters[left] = characters[right];
                characters[right] = leftCharacter;
            }
            left++;
            right--;
        }
        return String.join("", characters);
    }

    public String reverseWordsBruteForce(String s) {
        String[] wordsArray = s.split(" ");
        return Arrays.stream(wordsArray)
                .map(this::reverseWordBruteForce)
                .collect(Collectors.joining(" "));
    }

    private String reverseWordBruteForce(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }

    @Test
    public void reverseWordsTest() {
        assertEquals("s'teL ekat edoCteeL tsetnoc", reverseWords("Let's take LeetCode contest"));
        assertEquals("doG gniD", reverseWords("God Ding"));
        assertEquals("uoY ekil em", reverseWords("You like me"));
    }
}
