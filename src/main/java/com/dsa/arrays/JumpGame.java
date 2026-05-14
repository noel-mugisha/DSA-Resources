package com.dsa.arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[][] nums = {
                {2,3,1,1,4},
                {3,2,1,0,4}
        };
        for (int[] num : nums) {
            System.out.println(canJump(num));
        }
    }

    static boolean canJump(int[] nums) {
        int farthest = 0, i = 0;
        while (i < nums.length) {
            if (i > farthest)
                return false;
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length-1)
                break;

            i++;
        }
        return true;
    }
}
