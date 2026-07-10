package com.dsa.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandPointer {

    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node temp1 = dummy;
        int i = 0;
        Map<Node, Integer> oldNodesMap = new HashMap<>();
        while (head != null) {
            Node newNode = new Node(head.val);
            newNode.next = head.next;
            newNode.random = head.random;

            // save the old node
            oldNodesMap.put(head, i);
            i++;

            temp1.next = newNode;
            temp1 = temp1.next;
            head = head.next;
        }

        Map<Integer, Node> newNodesMap = new HashMap<>();
        int j = 0;
        Node temp2 = dummy.next;
        while (temp2 != null) {
            newNodesMap.put(j, temp2);
            j++;
            temp2 = temp2.next;
        }

        Node temp3 = dummy.next;

        while (temp3 != null) {
            if (temp3.random == null) {
                temp3 = temp3.next;
                continue;
            }

            int index = oldNodesMap.get(temp3.random);
            temp3.random = newNodesMap.get(index);

            temp3 = temp3.next;
        }

        return dummy.next;
    }
}
