package com.dsa.LinkedLists;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }

        return false;
    }

    // finding length of the cycle
    public int cycleLen(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int cycleLen = 0;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                do {
                    slow = slow.next;
                    cycleLen++;
                } while (slow != fast);
            }
        }

        return cycleLen; // If no cycle exists
    }
}
