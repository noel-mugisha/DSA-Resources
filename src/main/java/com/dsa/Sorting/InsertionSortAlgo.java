package com.dsa.Sorting;

import java.util.Arrays;

public class InsertionSortAlgo {

    static int[] insertionSort (int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;

            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {343,5690,12,56,767,230,345,23};
//        int[] nums = {1};
        var answ = insertionSort(nums);
        System.out.println(Arrays.toString(answ));
    }
}
