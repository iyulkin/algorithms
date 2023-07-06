package com.khakimova.java.leetcode.easy;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleOfTheLinkedList {

//  Two Pointers
//  Let's use slow and fast pointers to go through the linked list: slow is 1-node speed, fast is 2-node speed.
//  When the fast pointer gets to the end of linked list, slow one will be right in the middle.
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
