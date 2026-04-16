package com.dsa.slidingWindow;

public class MaxSumOfNums {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 3, 3, 4, 5, -1};
        System.out.println(findMaxSum(nums, 4));
    }

    static int findMaxSum(int[] arr, int k) {
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        for (int j =  k; j < arr.length; j++) {
            windowSum -= arr[j - k];
            windowSum += arr[j];

            maxSum = Math.max(maxSum, windowSum);
        }

         return maxSum;
    }
}
