package medium;


import java.util.HashMap;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * <p>
 * In other words, return true if one of s1's permutations is the substring of s2.
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> charactersMap = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            charactersMap.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }
        int leftPointer = 0, rightPointer = 0;
        while (rightPointer < s2.length() && !charactersMap.isEmpty()) {
            char characterAtRightPointer = s2.charAt(rightPointer);
            if (charactersMap.containsKey(characterAtRightPointer)) {
                charactersMap.compute(characterAtRightPointer, (k, v) -> v == 1 ? null : v - 1);
                rightPointer++;
            } else {
                while (leftPointer <= rightPointer && !charactersMap.containsKey(characterAtRightPointer)) {
                    charactersMap.compute(s2.charAt(leftPointer), (k, v) -> v == null ? 1 : v + 1);
                    leftPointer++;
                }
            }
        }
        return charactersMap.isEmpty();
    }

    @Test
    public void test() {
        assertTrue(checkInclusion("ab", "eidbaooo"));
        assertFalse(checkInclusion("ab", "eidboaoo"));
    }
}
