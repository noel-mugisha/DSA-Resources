package com.dsa.trees.learning;

import java.util.Arrays;

public class ArraySegmentTree {

    private int[] tree;
    private int[] nums;

    public ArraySegmentTree(int[] nums) {
        this.nums = nums;
        this.tree = new int[4 * nums.length];
        build(0, 0, nums.length - 1);
    }

    private int build(int index, int start, int end) {
        if (start == end) {
            tree[index] = nums[start];
            return tree[index];
        }

        int mid = start + (end - start) / 2;
        int leftChild = (2 * index) + 1, rightChild = (2 * index) + 2;

        int leftSum = build(leftChild, start, mid);
        int rightSum = build(rightChild, mid + 1, end);

        return tree[index] = leftSum + rightSum;
    }

    public String printTree() {
        return Arrays.toString(tree);
    }

    public int query(int startIndex, int endIndex) {
        return query(startIndex, endIndex, 0, 0, nums.length - 1);
    }

    private int query(int queryStartIndex, int queryEndIndex, int index, int start, int end) {
        if (start >= queryStartIndex && end <= queryEndIndex)
            return tree[index];

        if (start > queryEndIndex || end < queryStartIndex)
            return 0;

        int mid = start + (end - start) / 2;
        int leftChild = (2 * index) + 1, rightChild = (2 * index) + 2;

        int leftSum = query(queryStartIndex, queryEndIndex, leftChild, start, mid);
        int rightSum = query(queryStartIndex, queryEndIndex, rightChild, mid + 1, end);

        return leftSum + rightSum;
    }

    public void update(int index, int value) {
        update(index, value, 0, 0, nums.length - 1);
    }

    private void update(int index, int value, int nodeIndex, int start, int end) {
        if (start == end) {
            tree[nodeIndex] = value;
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = (2 * nodeIndex) + 1, rightChild = (2 * nodeIndex) + 2;

        if (index <= mid)
            update(index, value, leftChild, start, mid);
        else
            update(index, value, rightChild, mid + 1, end);

        tree[index] = tree[leftChild] + tree[rightChild];
    }
}
