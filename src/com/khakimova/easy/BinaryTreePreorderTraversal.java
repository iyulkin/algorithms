package com.khakimova.easy;

import com.sun.source.tree.Tree;
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
            if(node == null) {
                continue;
            }
            stack.push(node.right);
            stack.push(node.left);
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
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));

        return result;
    }

    @Test
    public void preorderTraversalTest() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        assertTrue(List.of(1, 2, 3).equals(preorderTraversal(root)));
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
