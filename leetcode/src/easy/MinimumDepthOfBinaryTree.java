package easy;

import helper.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a binary tree, find its minimum depth.
 * <p>
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthOfBinaryTree {

    @Test
    public void test() {
        assertEquals(2, minDepth(new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertEquals(5, minDepth(new TreeNode(new Integer[]{2, null, 3, null, 4, null, 5, null, 6})));
    }

    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = minDepth(root.left);
        int rDepth = minDepth(root.right);

        if (lDepth == 0) {
            return 1 + rDepth;
        }
        if (rDepth == 0) {
            return 1 + lDepth;
        }
        return 1 + Math.min(lDepth, rDepth);
    }
}
