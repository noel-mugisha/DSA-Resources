package com.dsa.heaps;

public class HeapSort {

    public void sort (int[] arr) {
        if (arr.length <= 1)
            return;

        heapify(arr);
        for (int end = arr.length - 1; end > 0; end--) {
            swapp(arr, 0, end);
            heapifyDown(arr, 0, end);
        }
    }

    private void heapify(int[] arr) {
        int size = arr.length;
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyDown(arr, i, size);
        }
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void heapifyDown(int[] arr, int index, int size) {
        // We heapify down if and only if that index has childre
        // An index has children if its left child is < size
        while (leftChild(index) < size) {
            int left = leftChild(index), right = rightChild(index);
            int maxChild = left;

            if (right < size && arr[right] > arr[left])
                maxChild = right;

            if (arr[index] >= arr[maxChild])
                break;

            swapp(arr, index, maxChild);
            index = maxChild;
        }
    }

    private void swapp(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
