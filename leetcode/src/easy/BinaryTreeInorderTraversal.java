package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {
    // DFS iteratively
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> traversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            traversal.add(stack.peek().val);
            node = stack.pop().right;
        }
        return traversal;
    }

    // DFS recursively
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList();
        result.addAll(inorderTraversalRecursive(root.left));
        result.add(root.val);
        result.addAll(inorderTraversalRecursive(root.right));

        return result;
    }

    @Test
    public void inorderTraversalTest() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        assertTrue(List.of(1, 3, 2).equals(inorderTraversal(root)));

        root = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        assertTrue(List.of(1, 3, 2).equals(inorderTraversal(root)));
    }

    @Test
    public void inorderTraversalRecursiveTest() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        assertTrue(List.of(1, 3, 2).equals(inorderTraversalRecursive(root)));
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
