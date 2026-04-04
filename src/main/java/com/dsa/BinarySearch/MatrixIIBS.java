package com.dsa.BinarySearch;

import java.util.Arrays;

public class MatrixIIBS {
    static int[] searchInMatrixII(int[][] nums, int target) {
        int row = 0;
        int col = nums[0].length -1;

        while (row<nums.length && col>=0) {
            int value = nums[row][col];

            if (value == target)
                return new int[] {row, col};
            if (value < target)
                row++;
            else
                col--;
        }

        return  new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1,4,7,11},
                {2,5,8,12},
                {3,6,9,16},
                {10,13,14,17}
        };
        int target = 14;
        System.out.println(Arrays.toString(searchInMatrixII(nums, target)));
    }
}
