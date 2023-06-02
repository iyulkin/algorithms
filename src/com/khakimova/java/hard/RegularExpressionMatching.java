package com.khakimova.java.hard;

import org.junit.jupiter.api.Test;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {

    @Test
    public void test() {
    }

    public boolean isMatch(String s, String p) {
        if(p.length() > s.length() || p.startsWith("*")) {
            return false;
        }
        int sInd = 0;
        int pInd = 0;
        while(pInd < p.length() && sInd < s.length()) {
            if(p.charAt(pInd) == '*') {
                while(s.charAt(sInd) == s.charAt(sInd - 1) && sInd < s.length()) {
                    sInd++;
                }
            } else if(p.charAt(pInd) == '.' || p.charAt(pInd) == s.charAt(sInd)) {
                sInd++;
                pInd++;
            }
        }
        return pInd == p.length() && sInd == s.length();
    }
}
