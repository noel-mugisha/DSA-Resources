package com.dsa.BinarySearch;

import java.util.Arrays;

public class MatrixBS {
    public static void main(String[] args) {
        int[][] nums = {
                {1 ,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 20;
        System.out.println(Arrays.toString(searchInMatrix(nums, target))); //[1,3]
    }

    static int[] searchInMatrix(int[][] nums, int target) {
        int rows = nums.length;
        int cols = nums[0].length;
        int start = 0;
        int end = (rows * cols) - 1;

        while (start <= end) {
            int mid = start+(end-start)/2;
            int r = mid / cols;
            int c = mid % cols;
            int value = nums[r][c];
            
            if (value == target)
                return new int[] {r, c};

            if (value < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return new int[]{-1, -1};
    }
}
