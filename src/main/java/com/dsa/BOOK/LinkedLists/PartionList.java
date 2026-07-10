package com.dsa.BOOK.LinkedLists;

public class PartionList {
    ListNode partition(ListNode node, int x) {
        ListNode lDummy = new ListNode(0);
        ListNode gDummy = new ListNode(0);
        ListNode lPointer = lDummy;
        ListNode gPointer = gDummy;

        while (node != null) {
            if (node.val < x) {
                lPointer.next = node;
                lPointer = lPointer.next;
            } else {
                gPointer.next = node;
                gPointer = gPointer.next;
            }

            node = node.next;
        }

        gPointer.next = null;
        lPointer.next = gDummy.next;

        return lDummy.next;
    }
}
