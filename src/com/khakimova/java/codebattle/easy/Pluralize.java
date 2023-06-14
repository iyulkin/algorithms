package com.khakimova.java.codebattle.easy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Pluralize {

    @Test
    public void test() {
        assertEquals(List.of("cows", "pig"), solution(List.of("cow", "pig", "cow", "cow")));
        assertEquals(List.of("chairs"), solution(List.of("chair", "chair", "chair")));
    }

    public List<String> solution(List<String> words) {
        return words.stream().distinct().map(w -> Collections.frequency(words, w) > 1 ? w + "s" : w).collect(Collectors.toList());
    }
}
