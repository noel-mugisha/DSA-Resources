package com.dsa.recursion;

import java.util.Arrays;

public class InPlaceMergeSort {
    public static void main(String[] args) {
        int[][] tests = {
                {},
                {5},
                {1,2,3,4,5},
                {5,4,3,2,1},
                {2,1},
                {3,1,4,2,5},
                {8,3,5,2},
                {4,2,2,5,1,1},
                {7,7,7,7},
                {-3,-1,-7,2,0},
                {1000,-500,200,0,-1},
                {1,4,2,3},
                {2,5,1,4,3},
                {1,2,3,5,4},
                {10,9,8,7,6,5,4,3,2,1},
                {3,2,1,0},
                {5,1,2,3,4},
                {1,3,5,7,2,4,6,8}
        };

        for (int[] test : tests) {
            mergeSort(test);
            System.out.println(Arrays.toString(test));
        }
    }

    static void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        helper(arr, 0, arr.length-1);
    }

    static void helper (int[] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start)/2;

        helper(arr, start, mid);
        helper(arr, mid+1, end);

        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid-start+ 1; int n2 = end - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];


        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[start + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0; int j = 0; int k = start;

        while (i < n1 && j < n2) {
            if (leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
             arr[k] = rightArr[j];
             j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
}