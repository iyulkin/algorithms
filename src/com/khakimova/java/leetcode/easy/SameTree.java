package com.khakimova.java.leetcode.easy;

import com.khakimova.java.leetcode.helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {

    @Test
    public void test() {
        assertTrue(isSameTree(new TreeNode(new Integer[]{1,2,3}), new TreeNode(new Integer[]{1,2,3})));
        assertFalse(isSameTree(new TreeNode(new Integer[]{1, 2}), new TreeNode(new Integer[]{1,null,2})));
        assertFalse(isSameTree(new TreeNode(new Integer[]{1,2,1}), new TreeNode(new Integer[]{1,1,2})));
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        return p == q ||
                (p != null && q != null && p.val == q.val
                        && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
