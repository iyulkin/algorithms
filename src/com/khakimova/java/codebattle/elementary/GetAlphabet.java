package com.khakimova.java.codebattle.elementary;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAlphabet {

    @Test
    public void test() {
        assertEquals("adfs", solution("asfsfdss"));
        assertEquals("acgt", solution("acgtgcgagtg"));
        assertEquals("1234", solution("4123214"));
    }

    private String solution(String s) {
        return Arrays.stream(s.split("")).distinct().sorted().collect(Collectors.joining());
    }
}
