package com.khakimova.java.leetcode.easy;

import com.khakimova.java.leetcode.helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

    @Test
    public void test() {
        assertTrue(isSymmetric(new TreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3})));
        assertFalse(isSymmetric(new TreeNode(new Integer[]{1, 2, 2, null, 3, null, 3})));
    }

    private boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return areSymmetric(root.left, root.right);
    }

    private boolean areSymmetric(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return left == null;
        }
        return left.val == right.val
                && areSymmetric(left.left, right.right)
                && areSymmetric(left.right, right.left);
    }
}
