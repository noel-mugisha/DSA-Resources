package com.dsa.Sorting;

import java.util.Arrays;

public class CyclicSort {
    static int[] cyclicSort (int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,2,1,3};
        System.out.println(Arrays.toString(cyclicSort(nums)));
    }
}
