package com.dsa.trees.learning;

public class SegmentTree {
    private static class Node {
        int start;
        int end;
        int sum;

        Node left;
        Node right;

        Node(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private Node root;

    SegmentTree() {}

    public void buildTree(int[] arr) {
        this.root = build(arr, 0, arr.length - 1);
    }

    private Node build(int[] arr, int start, int end) {
        Node node = new Node(start, end);
        if (start == end) {
            node.sum = arr[start];
            return node;
        }

        int mid = start + (end - start) / 2;
        node.left = build(arr, start, mid);
        node.right = build(arr, mid + 1, end);

        node.sum = node.left.sum + node.right.sum;

        return node;
    }

    public int query(int startIndex, int endIndex) {
        if (root == null)
            return 0;
        return query(root, startIndex, endIndex);
    }

    private int query(Node node, int startIndex, int endIndex) {
        if (node.start > endIndex || node.end < startIndex)
            return 0;

        else if (node.start >= startIndex && node.end <= endIndex)
            return node.sum;

        int leftSum = query(node.left, startIndex, endIndex);
        int rightSum = query(node.right, startIndex, endIndex);
        return leftSum + rightSum;
    }

    public void update(int index, int value) {
        update(root, index, value);
    }

    private void update(Node node, int index, int value) {
        if (node.start == node.end) {
            node.sum = value;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;

        if (index <= mid)
            update(node.left, index, value);
        else
            update(node.right, index, value);

        node.sum = node.left.sum + node.right.sum;
    }
}
