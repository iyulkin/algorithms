package com.khakimova.java.leetcode.easy;

import com.khakimova.java.leetcode.helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Given a binary tree, determine if it is
 * height-balanced
 */
public class BalancedBinaryTree {

    @Test
    public void test() {
        assertTrue(isBalanced(new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertFalse(isBalanced(new TreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        assertTrue(isBalanced(null));
    }

    private boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(depth(root.left) - depth(root.right)) < 2 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
