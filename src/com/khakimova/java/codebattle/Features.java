package com.khakimova.java.codebattle;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Features {

    @Test
    public void test() {
        assertEquals("clojure", reverseString("erujolc"));
        assertEquals(List.of(3, 5, 2), reverseCollection(List.of(2, 5, 3)));
    }

    private List<Integer> reverseCollection(List<Integer> list) {
        return list.stream().collect(Collectors.collectingAndThen(Collectors.toList(),
                l -> {
                    Collections.reverse(l);
                    return l;
                }));
    }

    private String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
