package com.dsa.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node (int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);
        removeNode(node);
        addLast(node);

        return node.value;
    }

    public void put(int key, int value) {
        // We already have the key, we are just updating
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            removeNode(node);
            addLast(node);
        }
        // We are adding a new element
        else {
            // so what if our capacity is full, we remove our LRU element which is our head
            if (map.size() == capacity) {
                map.remove(head.key);
                removeNode(head);
            }
            // add a new element
            Node node = new Node(key, value);
            map.put(key, node);
            addLast(node);
        }
    }

    void removeNode(Node node) {
        // Only one element
        if (head == node && tail == node) {
            head = null;
            tail = null;
        }
        // If we are removing the head
        else if (node == head) {
            head = head.next;
            head.prev = null;
        }
        // If we are removing the tail
        else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        // A middle element
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = null;
        node.next = null;
    }

    void addLast(Node node) {
        // We removed a single element
        if (tail == null) {
            head = node;
            tail = node;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }
}