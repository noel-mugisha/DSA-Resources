package com.dsa.BOOK.LinkedLists;

public class NthToLast {
    ListNode nthTolast(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
