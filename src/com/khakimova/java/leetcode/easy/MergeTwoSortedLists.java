package com.khakimova.java.leetcode.easy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class MergeTwoSortedLists {

    @Test
    public void test() {
        ListNode mergedList = mergeTwoLists(new ListNode(new int[]{1, 2, 4}), new ListNode(new int[]{1, 3, 4}));
        assertNotNull(mergedList);
        assertThat(mergedList.toArray(), is(new int[]{1, 1, 2, 3, 4, 4}));

        mergedList = mergeTwoLists(null, new ListNode(0));
        assertNotNull(mergedList);
        assertThat(mergedList.toArray(), is(new int[]{0}));

        assertNull(mergeTwoLists(null, null));
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(int[] nodes) {
            if (nodes == null || nodes.length == 0) {
                throw new IllegalArgumentException();
            }
            this.val = nodes[0];
            this.next = null;
            ListNode current = this;
            for (int i = 1; i < nodes.length; i++) {
                ListNode next = new ListNode(nodes[i]);
                current.next = next;
                current = next;
            }
        }

        public int[] toArray() {
            List<Integer> result = new ArrayList<>();
            result.add(val);
            ListNode nextNode = next;
            while (nextNode != null) {
                result.add(nextNode.val);
                nextNode = nextNode.next;
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
