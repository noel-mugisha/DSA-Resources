package com.dsa.LinkedLists;

public class SizeOfCycleLinkedList {
    public int lengthWithCycle (ListNode head) {
        // has cycle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int totalLen = 0;
                // first find len of the cycle
                do {
                    slow = slow.next;
                    totalLen++;
                } while (slow != fast);
                // second find len before cycle
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                    totalLen++;
                }
                return totalLen;
            }
        }
        // No cycle exists
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
}
