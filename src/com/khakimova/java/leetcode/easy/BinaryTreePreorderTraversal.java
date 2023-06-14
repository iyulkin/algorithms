package com.khakimova.java.leetcode.easy;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal {
    // DFS iteratively
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            traversal.add(node.val);
        }
        return traversal;
    }

    // DFS recursively
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList();
        result.add(root.val);
        result.addAll(preorderTraversalRecursive(root.left));
        result.addAll(preorderTraversalRecursive(root.right));

        return result;
    }

    @Test
    public void preorderTraversalTest() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        assertTrue(List.of(1, 2, 3).equals(preorderTraversal(root)));
    }

    @Test
    public void preorderTraversalRecursiveTest() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        assertTrue(List.of(1, 2, 3).equals(preorderTraversalRecursive(root)));
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
