package com.dsa.recursion;

import java.util.Arrays;

public class SelectionSortRecursion {
    public static void main(String[] args) {
        int[][] tests = {
                {},
                {5},
                {1,2,3,4,5},
                {5,4,3,2,1},
                {2,2,2,2,2},
                {4,2,5,2,3},
                {-3,-1,-7,2,0},
                {1,2,3,4,0},
                {5,1,2,3,4},
                {3,1,2},
                {4,5,6,1},
                {9,3,7,1,8,2},
                {1000,-500,200,0,-1},
                {10,9,8,7,6,5,4,3,2,1},
                {2,3,1,4}
        };

        for (int[] test : tests) {
            System.out.println(Arrays.toString(selectionSort(test)));
        }

    }

    static int[] selectionSort (int[] arr) {
        int i = arr.length -1;
        int maxIndex = 0;
        int j = 1;
        return helper (arr, i, j, maxIndex);
    }

    static int[] helper(int[] arr, int i, int j, int maxIndex) {
        if (arr.length <= 1 || i == 0) return arr;

        if (j == i) {
            if (arr[maxIndex] > arr[i]) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[i];
                arr[i] = temp;
            }

            return helper(arr, i-1, 1, 0);
        }

        if (arr[maxIndex] < arr[j]) maxIndex = j;

        return helper(arr, i, j+1, maxIndex);
    }
}
