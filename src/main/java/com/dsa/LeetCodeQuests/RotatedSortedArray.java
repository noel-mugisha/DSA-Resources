package com.dsa.LeetCodeQuests;

public class RotatedSortedArray {

    static int rotatedBinarySearch (int[] nums, int target) {
       int start = 0;
       int end = nums.length-1;
       while (start <= end) {
           int mid = start + (end - start)/2;
           if (nums[mid] == target)
               return mid;
           // left side is sorted
           else if (nums[start] <= nums[mid]) {
               if (nums[start]<=target && target<nums[mid])
                   end = mid-1;
               else
                   start = mid+1;
           }
           // right side is sorted
           else {
               if (nums[mid]<target && target<=nums[end])
                   start = mid+1;
               else
                   end = mid-1;
           }
       }
       return -1;
    }

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end])
                start = mid + 1;

            else if (nums[mid] < nums[end])
                end = mid;

            else
                if (nums[start] > nums[start+1])
                    return start + 1;
                start++;
                if (nums[end] < nums[end-1])
                    return end;
                end--;
        }

        return start;
    }
}
