package com.dsa.arrays;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[][] nums = {
                {0,1,0,3,12},
                {0}
        };
        for (int[] num : nums) {
            moveZeroes(num);
        }
    }

    static void moveZeroes(int[] nums) {
        int l = -1;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                l++;
                swap(nums, l, r);
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    static void swap (int[] nums, int x, int z) {
        int temp = nums[x];
        nums[x] = nums[z];
        nums[z] = temp;
    }
}
