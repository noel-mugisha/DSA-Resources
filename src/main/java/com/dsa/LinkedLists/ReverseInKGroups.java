package com.dsa.LinkedLists;

public class ReverseInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if  (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(), prev = dummy;
        dummy.next = head;
        ListNode curr = head;

        while (curr != null) {
            ListNode scout = curr;
            // Check if they are k-nodes
            for (int i = 0; i < k; i++) {
                if (scout == null)
                    return dummy.next;
                scout = scout.next;
            }
            // In place reversal
            for (int i = 1; i < k; i++) {
                ListNode temp = curr.next;
                curr.next = curr.next.next;
                temp.next = prev.next;
                prev.next = temp;
            }
            prev = curr;
            curr = scout;
        }

        return dummy.next;
    }
}
