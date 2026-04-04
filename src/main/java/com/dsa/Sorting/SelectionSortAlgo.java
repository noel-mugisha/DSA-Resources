package com.dsa.Sorting;

import java.util.Arrays;

public class SelectionSortAlgo {

    static int[] selectionSort (int[] arr) {
        int n = arr.length;

        for (int i = n-1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[maxIndex] < arr[j])
                    maxIndex = j;
            }

            if (i != maxIndex) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
//        int[] nums = {343,56,12,5690,767,23,345,230};
        int[] nums = {2,1};
        var answ = selectionSort(nums);
        System.out.println(Arrays.toString(answ));
    }
}
