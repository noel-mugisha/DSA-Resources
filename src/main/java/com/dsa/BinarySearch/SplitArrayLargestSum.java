package com.dsa.BinarySearch;

public class SplitArrayLargestSum {
    static int splitArray (int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }

        while (start < end) {
            int mid = start + (end-start)/2;
            int pieces = 1;
            int currentSum = 0;

            for (int num : nums) {
                if (currentSum+num > mid) {
                    pieces++;
                    currentSum = num;
                }
                else
                    currentSum += num;
            }

            if (pieces <= k)
                end = mid;
            else
                start = mid+1;
        }

        return start;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k =2;
        System.out.println(splitArray(nums,2));// answ: 18
    }
}

