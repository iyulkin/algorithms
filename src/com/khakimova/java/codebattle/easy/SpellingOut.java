package com.khakimova.java.codebattle.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellingOut {

    @Test
    public void test() {
        assertEquals(List.of("b","be","bee"), solution("bee"));
        assertEquals(List.of("h","ha","hap","happ","happy"), solution("happy"));
    }

    private List<String> solution(String word) {
        if (word == null || word.length() == 0) {
            return Collections.emptyList();
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            res.add(word.substring(0, i + 1));
        }
        return res;
    }
}
