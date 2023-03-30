package com.khakimova.java.easy;

import com.khakimova.java.helper.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointer1 = headA;
        ListNode pointer2 = headB;

        while(pointer1 != pointer2) {
            if(pointer1 == null) {
                pointer1 = headB;
            } else {
                pointer1 = pointer1.next;
            }

            if(pointer2 == null) {
                pointer2 = headA;
            } else {
                pointer2 = pointer2.next;
            }
        }
        return pointer1;
    }

    public ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {
        Set<ListNode> setOfNodes = new HashSet<>();
        ListNode node = headA;
        while(node != null) {
            setOfNodes.add(node);
            node = node.next;
        }
        node = headB;
        while(node != null) {
            if(!setOfNodes.add(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
