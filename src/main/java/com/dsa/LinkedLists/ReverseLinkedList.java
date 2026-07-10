package com.dsa.LinkedLists;

public class ReverseLinkedList {
    ListNode reverseList (ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    ListNode reverseListWithRecursion (ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseListWithRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    ListNode reverseWithInsertionHead(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (head.next != null) {
            ListNode temp = head.next;
            head.next = head.next.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }

        return dummy.next;
    }
}
