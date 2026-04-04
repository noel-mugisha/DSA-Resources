package com.dsa.recursion;

import java.util.Arrays;

public class BubbleSortRecursion {
    public static void main(String[] args) {
        int[][] tests = {
                {},
                {5},
                {1,2,3,4,5},
                {5,4,3,2,1},
                {1,2,3,5,4},
                {2,1,3,4,5},
                {4,2,2,3,1},
                {7,3,9,1,6,2},
                {1000,-1,500,0,999},
                {1,3,2,4,5},
                {1,2,3,6,5,4}
        };

        for (int[] test : tests) {
            System.out.println(Arrays.toString(bubbleSort(test)));
        }
    }

    static int[] bubbleSort (int[] arr) {
        int n = arr.length;
        return helper(arr, n, 0, 0, false);
    }

    static int[] helper(int[] arr, int n, int i, int j, boolean isSwapped) {
        if (n == 0 || i == n-1) return arr;

        if (j == n-1-i) {
            if (!isSwapped) return arr;
            return helper(arr, n, i+1, 0, false);
        }

        if (arr[j] > arr[j+1]) {
            int temp = arr[j];
            arr[j] = arr[j+1];
            arr[j+1] = temp;
            isSwapped = true;
        }

        return helper(arr, n, i, j+1, isSwapped);
    }
}
