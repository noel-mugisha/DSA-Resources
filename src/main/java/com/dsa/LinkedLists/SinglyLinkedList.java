package com.dsa.LinkedLists;

public class SinglyLinkedList {
    private static class Node {
        int value;
        Node next;
        Node (int value){
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        size = 0;
    }

    public int size () {
        return size;
    }

    public void addFirst (int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast (int value) {
        Node node = new Node(value);
        if (tail == null) {
            tail = node;
            head = tail;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void add (int value) {
        addLast(value);
    }

    public void add (int index, int value) {
        checkPositionIndex(index);

        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            addLast(value);
            return;
        }
        Node node = new Node(value);
        Node prevNode = getNode(index-1);
        node.next = prevNode.next;
        prevNode.next = node;
        size++;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException(
                    "Cannot remove from an empty list");
        }

        int value = head.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }

        size--;

        return value;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException(
                    "Cannot remove from an empty list");
        }
        int value = tail.value;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node prevNode = getNode(size - 2);
            prevNode.next = null;
            tail = prevNode;
        }

        size--;
        return value;
    }

    public int remove (int index) {
        checkElementIndex(index);

        if (index == 0)
            return removeFirst();

        if (index == size - 1)
            return removeLast();

        Node prevNode = getNode(index - 1);
        int value = prevNode.next.value;
        prevNode.next = prevNode.next.next;

        size--;
        return value;
    }

    public int get(int index) {
        Node node = getNode(index);
        return node.value;
    }

    public void set(int index, int newValue) {
        checkElementIndex(index);
        Node node = getNode(index);
        node.value = newValue;
    }

    public boolean contains (int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.value == value) {
                return index;
            }
            temp = temp.next;
            index++;
        }

        return -1;
    }

    public boolean isEmpty () {
        return size == 0;
    }

    public void clear () {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertUsingRec(int value, int index) {
        checkPositionIndex(index);
        head = helper(head, value, index);
    }

    private Node helper(Node temp, int value, int index) {
        if (index == 0) {
            Node node = new Node(value);
            node.next = temp;
            size++;
            return node;
        }
        temp.next = helper(temp.next, value, index-1);
        return temp;
    }

    private Node getNode(int index) {
        checkElementIndex(index);
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.value);
            sb.append(" -> ");
            temp = temp.next;
        }
        sb.append("End]");
        return sb.toString();
    }
}
