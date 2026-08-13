package com.dsa.heaps;

public class MaxHeap {
    private int[] heap;
    private int capacity;
    private int size;


    public MaxHeap(int capacity) {
        heap = new int[capacity];
        this.capacity = capacity;
        size = 0;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return (2 * index) + 1;
    }

    private int rightChild(int index) {
        return (2 * index) + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int peek() {
        if (size == 0)
            throw new IllegalArgumentException("No element available..");

        return heap[0];
    }

    private void heapifyUp() {
        int index = size - 1;
        int parentIndex = parent(index);

        while (index > 0) {
            if (heap[index] <= heap[parentIndex])
                break;

            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    public void insert(int value) {
        if (size == capacity)
            throw new IllegalArgumentException("Array is already full");

        heap[size] = value;
        size++;

        heapifyUp();
    }

    public int remove() {
        if (size == 0)
            throw new IllegalArgumentException("No element available..");

        int removedValue = heap[0];

        heap[0] = heap[size - 1];
        size--;

        heapifyDown();
        return removedValue;
    }

    private void heapifyDown() {
        int index = 0;
        while (leftChild(index) < size) {
            int left = leftChild(index);
            int right = rightChild(index);

            int maxChild = left;
            if (right < size && heap[right] > heap[left])
                maxChild = right;

            if (heap[index] >= heap[maxChild])
                break;

            swap(index, maxChild);

            index = maxChild;
        }
    }

    // Take O(n) TC because leaf nodes need no work, which is n/2 leaf nodes, and then n/4 move only one time, n/8 move 2 times etc...
    public void buildHeap(int[] arr) {
        heap = arr;
        size = arr.length;

        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private void heapifyDown(int index) {

        while (leftChild(index) < size) {
            int left = leftChild(index);
            int right = rightChild(index);

            int maxChild = left;
            if (right < size && heap[right] > heap[left])
                maxChild = right;

            if (heap[index] >= heap[maxChild])
                break;

            swap(index, maxChild);

            index = maxChild;
        }
    }
}
