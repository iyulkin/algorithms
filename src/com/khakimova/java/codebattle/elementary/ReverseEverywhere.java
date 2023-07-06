package com.khakimova.java.codebattle.elementary;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseEverywhere {
    @Test
    public void test() {
        assertEquals(List.of("emosewa", "si", "erujolc"), solution(List.of("clojure", "is", "awesome")));
        assertEquals(List.of("yoj","sgnirb","ybur"), solution(List.of("ruby","brings","joy")));
    }

    private List<String> solution(List<String> words) {
        return words.stream().map(this::reverseString)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return list;
                        }));
    }

    private String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
