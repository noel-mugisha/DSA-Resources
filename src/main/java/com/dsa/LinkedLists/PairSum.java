package com.dsa.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
    public int pairSum(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        int listLen = 0, index = 0;
        ListNode curr = head;
        while (curr != null) {
            map.put(index, curr.val);
            index++;
            listLen++;
            curr = curr.next;
        }

        int pairMaxSum = 0;

        for (int i = 0; i < listLen / 2; i++) {
            int j = listLen - 1 - i;
            int jValue = map.get(j);
            int iValue = map.get(i);

            pairMaxSum = Math.max(pairMaxSum, jValue + iValue);
        }

        return pairMaxSum;
    }
}
