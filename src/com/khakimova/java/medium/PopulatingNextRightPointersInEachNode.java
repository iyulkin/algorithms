package com.khakimova.java.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL
 */
public class PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);

        return root;
    }

    public Node connect1(Node root) {
        Queue<Node> queue = new LinkedList<>();
        addNodeToQueue(root, queue);
        populateNextRight(queue);
        return root;
    }

    private void populateNextRight(Queue<Node> queue) {
        if (queue.isEmpty()) {
            return;
        }
        Queue<Node> children = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.next = queue.peek();
            addNodeToQueue(node.left, children);
            addNodeToQueue(node.right, children);
        }
        populateNextRight(children);
    }

    private void addNodeToQueue(Node node, Queue<Node> queue) {
        if (node != null) {
            queue.add(node);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
