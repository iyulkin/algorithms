package com.khakimova.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {

    @Test
    public void test() {
        Assertions.assertTrue(isValid(""));
        Assertions.assertTrue(isValid("()"));
        Assertions.assertTrue(isValid("()[]{}"));
        Assertions.assertFalse(isValid("(}"));
    }

    private boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        Map<String, String> brackets = new HashMap<>();
        brackets.put(")", "(");
        brackets.put("]", "[");
        brackets.put("}", "{");

        for (int i = 0; i < s.length(); i++) {
            String bracket = String.valueOf(s.charAt(i));
            String matchingBracket = brackets.get(bracket);
            if (matchingBracket == null) {
                stack.push(bracket);
            } else {
                if (stack.isEmpty() ||
                        !stack.pop().equals(matchingBracket)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
