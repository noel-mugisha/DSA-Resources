package com.dsa.trees.learning;

import java.util.Arrays;

public class ArrSeg2 {

    private int[] nums;
    private int[] tree;
    private int[] lazy;

    public ArrSeg2(int[] arr) {
        this.nums = arr;
        this.tree = new int[4 * arr.length];
        this.lazy = new int[4 * arr.length];
        build(arr, this.tree, 0, 0, arr.length - 1);
    }

    private void build(int[] arr, int[] tree, int index, int start, int end) {
        if (start == end) {
            tree[index] = arr[start];
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;

        build(arr, tree, leftChild, start, mid);
        build(arr, tree, rightChild, mid + 1, end);

        tree[index] = tree[leftChild] + tree[rightChild];
    }

    public String printTree() {
        return Arrays.toString(this.tree);
    }

    public int query(int startIndex, int endIndex) {
        return query(0, 0, this.nums.length - 1, startIndex, endIndex);
    }

    private int query(int index, int start, int end, int qSindex, int qEindex) {
        if (end < qSindex || qEindex < start)
            return 0;

        if (start >= qSindex && end <= qEindex)
            return this.tree[index];

        int mid = start + (end - start) / 2;
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;

        // push pending changes in lazy if any
        push(index, start, end);

        int leftSum = query(leftChild, start, mid, qSindex, qEindex);
        int rightSum = query(rightChild, mid + 1, end, qSindex, qEindex);

        return leftSum + rightSum;
    }

    private void push(int index, int start, int end) {
        if (this.lazy[index] == 0)
            return;

        int value = lazy[index];
        int mid = start + (end - start) / 2;
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;

        apply(leftChild, start, mid, value);
        apply(rightChild, mid + 1, end, value);

        lazy[index] = 0;
    }

    private void apply(int index, int start, int end, int value) {
        this.tree[index] += value * (end - start + 1);
        if (start != end)
            this.lazy[index] += value;
    }

    public void updateIndex(int index, int newValue) {
        updateIndex(index, newValue, 0, 0, this.nums.length - 1);
    }

    private void updateIndex(int index, int value, int nodeIndex, int start, int end) {
        if (start == end) {
            tree[nodeIndex] = value;
            return;
        }

        push(nodeIndex, start, end);
        int mid = start + (end - start) / 2;
        int leftChild = (2 * nodeIndex) + 1, rightChild = (2 * nodeIndex) + 2;

        if (index <= mid)
            updateIndex(index, value, leftChild, start, mid);
        else
            updateIndex(index, value, rightChild, mid + 1, end);

        tree[nodeIndex] = tree[leftChild] + tree[rightChild];
    }

    public void updateRange(int startIndex, int endIndex, int value) {
        updateRange(0, 0, this.nums.length - 1, startIndex, endIndex, value);
    }

    private void updateRange(int index, int start, int end, int updStartIndex, int updEndIndex, int value) {
        if (end < updStartIndex || updEndIndex < start)
            return;

        if (start >= updStartIndex && end <= updEndIndex) {
            apply(index, start, end, value);
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = (2 * index) + 1;
        int rightChild = (2 * index) + 2;

        // push pending changes in lazy if any
        push(index, start, end);

        updateRange(leftChild, start, mid, updStartIndex, updEndIndex, value);
        updateRange(rightChild, mid + 1, end, updStartIndex, updEndIndex, value);

        this.tree[index] = this.tree[leftChild] + this.tree[rightChild];
    }
}
