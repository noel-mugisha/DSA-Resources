package com.dsa.arrays;

public class MaximumSubArr {
    public static void main(String[] args) {
        int[][] tests = {
                {-2,1,-3,4,-1,2,1,-5,4},
                {1},
                {5,4,-1,7,8}
        };

        for (int[] test : tests) {
            System.out.println(maxSubArray(test));
        }
    }
    static int maxSubArray(int[] nums) {
        int currentSum;
        int maxSum = currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i])
                currentSum = nums[i];
            else
                currentSum += nums[i];

            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
