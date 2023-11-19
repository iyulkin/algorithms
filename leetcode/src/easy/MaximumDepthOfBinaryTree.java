package easy;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

    @Test
    public void test() {
        assertEquals(2, maxDepth(new TreeNode(new Integer[]{1, null, 2})));
        assertEquals(3, maxDepth(new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
