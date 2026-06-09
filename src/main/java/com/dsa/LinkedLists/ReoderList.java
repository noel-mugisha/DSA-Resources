package com.dsa.LinkedLists;

public class ReoderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = findMid(head);
        ListNode reversedHead = reverseList(mid.next);
        mid.next = null;
        mergerLists (head, reversedHead);
    }

    void mergerLists(ListNode head, ListNode reversedHead) {
        while (reversedHead != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = reversedHead.next;
            head.next = reversedHead;
            reversedHead.next = temp1;

            head = temp1;
            reversedHead = temp2;
        }
    }

    ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    ListNode findMid (ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
