package com.dsa.BOOK.LinkedLists;

public class FindIntersection {

    ListNode findIntersection(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null)
            return null;

        int len1 = 1, len2 = 1;
        ListNode tail1 = list1, tail2 = list2;

        while (tail1.next != null) {
            len1++;
            tail1 = tail1.next;
        }
        while (tail2.next != null) {
            len2++;
            tail2 = tail2.next;
        }

        if (tail1 != tail2)
            return null;

        if (len1 > len2) {
            int i = len1 - len2;
            while (i > 0) {
                list1 = list1.next;
                i--;
            }
        } else if (len2 > len1) {
            int i = len2 - len1;
            while (i > 0) {
                list2 = list2.next;
                i--;
            }
        }

        while (list1 != null && list2 != null) {
            if (list1 == list2)
                return list1;
            list1 = list1.next;
            list2 = list2.next;
        }

        return null;
    }
}
