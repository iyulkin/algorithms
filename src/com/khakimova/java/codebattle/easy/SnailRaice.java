package com.khakimova.java.codebattle.easy;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SnailRaice {

    @Test
    public void test() {
        assertTrue(snailRace(List.of(37, 39, 23), List.of(20, 35, 9)));
    }

    private boolean snailRace(List<Integer> maurice, List<Integer> steve) {
        List<Integer> mauriceSorted = maurice.stream().sorted().collect(Collectors.toList());
        List<Integer> steveSorted = steve.stream().sorted().collect(Collectors.toList());
        int res = 0;

        if (mauriceSorted.get(1) > steveSorted.get(0)) {
            res++;
        }
        if (mauriceSorted.get(2) > steveSorted.get(1)) {
            res++;
        }
        return res > 1;
    }
}
