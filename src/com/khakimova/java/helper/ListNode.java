package com.khakimova.java.helper;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ListNode(int[] nodes) {
        if(nodes == null || nodes.length == 0) {
            throw new UnsupportedOperationException();
        }
        this.val = nodes[0];
        ListNode current = this;
        for(int v : nodes) {
            current.next = new ListNode(v);
            current = current.next;
        }
    }
}
