package com.dsa.recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[][] tests = {

                // 🟢 BASIC CASES
                {},
                {5},
                {2,1},
                {1,2,3},
                {3,2,1},

                // 🟡 NORMAL CASES
                {3,1,4,2,5},
                {8,3,5,2},
                {10,7,8,9,1,5},

                // 🔁 DUPLICATES (VERY IMPORTANT)
                {4,2,2,5,1,1},
                {7,7,7,7},
                {2,2,2,1,1,1,3,3,3},

                // 🔴 NEGATIVE NUMBERS
                {-3,-1,-7,2,0},
                {1000,-500,200,0,-1},

                // ⚫ EDGE CASES
                {Integer.MAX_VALUE, Integer.MIN_VALUE, 0},

                // 🧨 WORST CASE FOR YOUR PIVOT (LAST ELEMENT)
                {1,2,3,4,5,6,7,8,9},
                {9,8,7,6,5,4,3,2,1},

                // ⚠️ NEARLY SORTED (TRICKY)
                {1,2,3,5,4,6,7,8},

                // 🧩 RANDOM MIX
                {2,5,1,4,3},
                {5,1,2,3,4},
                {1,3,5,7,2,4,6,8}
        };

        for (int[] test : tests) {
            quickSort(test);
            System.out.println(Arrays.toString(test));
        }
    }

    static void quickSort (int[] arr) {
        if (arr.length <= 1) return;
        helper (arr, 0, arr.length-1);
    }

    static void helper (int[] arr, int start, int end) {
        if (start >= end) return;
        int position = partition(arr, start, end);
        helper(arr, start, position-1);
        helper(arr, position+1, end);
    }

    static int partition(int[] arr, int start, int end) {
        int i = start - 1; int pivot = arr[end];

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, j, i);
            }
        }

        swap(arr, i+1, end);

        return i+1;
    }

    static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
