package com.dsa.recursion;

import java.util.Arrays;

public class MergeSort {
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
            System.out.println(Arrays.toString(mergeSort(test)));
        }
//        int[] arr = {5,4,3,2,1};
//        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    static int[] mergeSort (int[] arr) {
        int n = arr.length;
        if (n == 1 || n == 0) return arr;
        int mid = n/2;

        int[] leftArr = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] rightArr = mergeSort(Arrays.copyOfRange(arr, mid, n));

        return merge(leftArr, rightArr);
    }

    static int[] merge(int[] leftArr, int[] rightArr) {
        int[] mergedArr = new int[leftArr.length + rightArr.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<leftArr.length && j<rightArr.length) {
            if (leftArr[i] < rightArr[j]) {
                mergedArr[k] = leftArr[i];
                i++;
            }
            else {
                mergedArr[k] = rightArr[j];
                j++;
            }

            k++;
        }

        while (i < leftArr.length) {
            mergedArr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightArr.length) {
            mergedArr[k] = rightArr[j];
            j++;
            k++;
        }

        return mergedArr;
    }
}
