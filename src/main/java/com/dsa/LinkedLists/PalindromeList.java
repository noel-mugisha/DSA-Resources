package com.dsa.LinkedLists;

public class PalindromeList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid = findMid(head);
        ListNode reversedHead = reverseList(mid);
        mid = null;
        while (head != null && reversedHead != null) {
            if (head.val != reversedHead.val)
                return false;
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return true;
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
