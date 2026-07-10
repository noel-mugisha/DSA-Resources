package com.dsa.BOOK.LinkedLists;

public class PalindromeList {
    boolean isPalindrome(ListNode head) {
        if (head.next == null)
            return true;

        ListNode mid = findMid(head);
        ListNode reversedHead = reverse(mid.next);
        mid = null;

        while (head != null && reversedHead != null) {
            if (head.val != reversedHead.val)
                return false;
            head = head.next;
            reversedHead = reversedHead.next;
        }

        return true;
    }

    ListNode findMid (ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    ListNode reverse (ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
