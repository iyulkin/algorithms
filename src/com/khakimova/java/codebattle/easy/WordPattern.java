package com.khakimova.java.codebattle.easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordPattern {

    @Test
    public void test() {
//        assertTrue(solution("zzbinqs", "dragonborn dragonborn by his honor in sworm"));
//        assertTrue(solution("abba", "dog cat cat dog"));
        assertFalse(solution("abba", "dog cat cat fisth"));
    }

    public Boolean solution(String str1, String str2) {
        Map<Character, String> map = new HashMap();
        List<String> words = Arrays.asList(str2.split(" "));
        if(str1.length() != words.size()) {
            return false;
        } else {
            for(int i = 0; i< str1.length(); i++) {
                Character ch = str1.charAt(i);
                String word = map.get(ch);
                if(word != null && !word.equals(words.get(i))) {
                    return false;
                }
                map.put(ch, words.get(i));
            }
            return true;
        }
    }
}
