package com.dsa.LinkedLists;

public class RemoveNthNode {
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null || head.next == null)
            return null;

        int len = 0;
        ListNode curr = head;

        while(curr != null) {
            len++;
            curr = curr.next;
        }

        int steps = len - n;

        if (steps == 0)
            return head.next;

        ListNode prev = null;
        ListNode curr2 = head;
        while (steps > 0) {
            prev = curr2;
            curr2 = curr2.next;
            steps--;
        }

        prev.next = prev.next.next;
        return head;
    }

}
