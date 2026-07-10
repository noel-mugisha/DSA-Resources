package com.dsa.BOOK.LinkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDups {

    void deleteDups(ListNode head){
        if (head == null || head.next == null)
            return;

        Set<Integer> set = new HashSet<>();
        ListNode prev = null;
        while (head != null) {
            if (!set.contains(head.val)) {
                set.add(head.val);
                prev = head;
                head = head.next;
            } else {
                prev.next = prev.next.next;
                head = prev.next;
            }
        }
    }
}
