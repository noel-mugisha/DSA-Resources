package com.dsa.BinarySearch;

class Solution {
    static int maximumCount(int[] nums) {
        int negCount = binarySearch(nums, 0);
        int posCount = nums.length - binarySearch(nums, 1);
        System.out.println(negCount + ", " + posCount);
        return Math.max(negCount, posCount);
    }

    static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1, result = nums.length;

        while (start < end) {
            int mid = start + (end-start) / 2;
            if (nums[mid] >= target) {
                end = mid;
                result = mid;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        System.out.println(maximumCount(nums));
    }
}