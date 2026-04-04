package com.dsa.Sorting;

import java.util.Arrays;

public class BubbleSortAlgo {

    static int[] bubbleSort (int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n-1; i++) {
            boolean iSswapped = false;
            for (int j = 0; j < n-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    iSswapped = true;
                }
            }
            if (!iSswapped)
                break;
        }

        return nums;
    }

    public static void main(String[] args) {
//        int[] nums = {343,56,12,56,767,23,345,23};
        int[] nums = {1};
        var answ = bubbleSort(nums);
        System.out.println(Arrays.toString(answ));
    }
}
