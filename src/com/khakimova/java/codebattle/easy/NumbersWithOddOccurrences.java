package com.khakimova.java.codebattle.easy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumbersWithOddOccurrences {

    @Test
    public void test() {
        assertEquals(List.of(34, 45), solution(List.of(12, 23, 34, 12, 12, 23, 12, 45)));
    }

    private List<Integer> solution(List<Integer> arr) {
       return arr.stream().filter(x -> Collections.frequency(arr, x) % 2 != 0)
               .distinct()
               .collect(Collectors.toList());
    }
}
