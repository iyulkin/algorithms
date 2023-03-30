package com.khakimova.java.easy;

import com.khakimova.java.helper.TreeNode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 * Left -> Right -> Root
 */
public class BinaryTreePostorderTraversal {

    @Test
    public void test() {
        assertEquals(List.of(3, 2, 1), postorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> traversal = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            traversal.addFirst(node.val);
        }

        return traversal;
    }
}
