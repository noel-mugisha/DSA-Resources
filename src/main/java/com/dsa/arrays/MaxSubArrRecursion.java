package com.dsa.arrays;

public class MaxSubArrRecursion {
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
        int n = nums.length;
        return (n == 1) ? nums[0] : helper(nums, 0, n-1);
    }

    static int helper (int[] nums, int start, int end) {
        if (start >= end)
            return nums[start];
        int mid = start + (end - start)/2;

        int leftSum = helper(nums, start, mid);
        int rightSum = helper(nums, mid+1, end);
        int crossSum = findCrossSum(nums, start, mid, end);

        return Math.max(leftSum, Math.max(rightSum, crossSum));
    }

    static int findCrossSum(int[] nums, int start, int mid, int end) {

        int leftMax = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = mid; i >= start; i--) {
            currentSum += nums[i];
            leftMax = Math.max(leftMax, currentSum);
        }

        int rightMax = Integer.MIN_VALUE;
        currentSum = 0;

        for (int i = mid + 1; i <= end; i++) {
            currentSum += nums[i];
            rightMax = Math.max(rightMax, currentSum);
        }

        return leftMax + rightMax;
    }

}
