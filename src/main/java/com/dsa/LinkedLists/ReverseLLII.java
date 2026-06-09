package com.dsa.LinkedLists;

public class ReverseLLII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy, current = head;
        for (int i = 1; i < left; i++) {
            prev = current;
            current = current.next;
        }

        ListNode connection = prev, tail = current;

        prev = current;
        current = current.next;

        for (int i = 1; i < (right - left + 1); i++) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        connection.next = prev;
        tail.next = current;

        return dummy.next;
    }

    //second approach, a.k.a. front insertion reversal inside a sublist
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++)
            prev = prev.next;

        ListNode current = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }
}
