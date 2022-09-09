package com.khakimova.java.easy;

import java.util.Objects;
import java.util.Stack;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * You are given two binary trees root1 and root2.
 * <p>
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * <p>
 * Return the merged tree.
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recursiveMerge(root1, root2);
    }

    private TreeNode iterativeMerge(TreeNode root1, TreeNode root2) {

        if (root1 == null) {
            return root2;
        }

        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{root1, root2});
        while (!stack.empty()) {
            TreeNode[] pair = stack.pop();
            if(pair[0] == null || pair[1] == null) {
                continue;
            }
            pair[0].val += pair[1].val;
            if(pair[0].left == null) {
                pair[0].left = pair[1].left;
            } else {
                stack.push(new TreeNode[]{pair[0].left, pair[1].left});
            }
            if(pair[0].right == null) {
                pair[0].right = pair[1].right;
            } else {
                stack.push(new TreeNode[]{pair[0].right, pair[1].right});
            }
        }
        return root1;
    }

    private TreeNode recursiveMerge(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        root1.val += root2.val;
        root1.left = recursiveMerge(root1.left, root2.left);
        root1.right = recursiveMerge(root1.right, root2.right);

        return root1;
    }

    @Test
    public void test() {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));
        TreeNode expected = new TreeNode(3, new TreeNode(4, new TreeNode(5), new TreeNode(4)), new TreeNode(5, null, new TreeNode(7)));
        assertThat(mergeTrees(root1, root2), equalTo(expected));
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
