package com.dsa.BOOK.LinkedLists;

public class DeleteMid {
    boolean deleteNode(ListNode n) {
        if (n == null || n.next == null)
            return false;
        ListNode next = n.next;
        n.val = next.val;
        n.next = n.next.next;

        return true;
    }
}
