package com.dsa.Sorting;

import java.util.Arrays;
import java.util.Random;

public class ModernQuickSort {
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
        helper (arr, 0, arr.length - 1);
    }

    static void helper (int[] arr, int start, int end) {
        if (start >= end) return;

        // In the worst case when the arr is sorted or sorted in reverse
        // we need to use a random element as our pivot to avoid O(N^2) time complexity
        // we use this approach:

//        int randIndex = start + new Random().nextInt(end - start + 1);
//        swap(arr, start, randIndex);

        int lt = start, gt = end;
        int pivot = arr[start], i = start + 1;
        while (i <= gt) {
            // Element is less than pivot
            if (arr[i] < pivot) {
                swap(arr, i, lt);
                lt++;
                i++;
            }
            // Element is greater than pivot
            else if (arr[i] > pivot) {
                swap(arr, i, gt);
                gt--;
            }
            // Element is equal to the pivot
            else
                i++;
        }

        helper(arr, start, lt - 1);
        helper(arr, gt + 1, end);
    }

    static void swap (int[] arr, int x, int z) {
        int temp = arr[x];
        arr[x] = arr[z];
        arr[z] = temp;
    }
}









