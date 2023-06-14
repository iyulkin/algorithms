package com.khakimova.java.codebattle.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoreThanMedium {

    @Test
    public void test() {
        assertEquals(List.of("there is no result!"), solution("test"));
        assertEquals(List.of("This","sample","string"), solution("This is a sample string"));
    }

    private List<String> solution(String sentence) {
        String[] s = sentence.split(" ");
        double average = Arrays.stream(s).map(w -> w.replace(".","")).mapToInt(String::length).average().orElse(0);
        List<String> list = Arrays.stream(s).map(w -> w.replace(".","")).filter(w -> w.length() > average).collect(Collectors.toList());
        if(list.isEmpty()) {
            return List.of("there is no result!");
        } else {
            return list;
        }
    }
}
