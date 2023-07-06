package com.khakimova.java.leetcode.helper;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer[] nodes) {
        if (nodes == null || nodes.length < 1) {
            throw new UnsupportedOperationException();
        }
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        this.val = nodes[0];
        nodesQueue.add(this);
        int i = 1;
        while (nodesQueue.size() > 0 && i < nodes.length - 1) {
            TreeNode node = nodesQueue.poll();
            Integer val = nodes[i++];
            if(val == null) {
                node.left = null;
            } else {
                node.left = new TreeNode(val);
                nodesQueue.add(node.left);
            }
            val = nodes[i++];
            if(val == null) {
                node.right = null;
            } else {
                node.right = new TreeNode(val);
                nodesQueue.add(node.right);
            }
        }
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
