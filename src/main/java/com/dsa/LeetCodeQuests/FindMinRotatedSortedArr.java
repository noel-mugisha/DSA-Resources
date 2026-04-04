package com.dsa.LeetCodeQuests;

public class FindMinRotatedSortedArr {

    static int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end])
                start = mid + 1;

            else
                end = mid;
        }

        return start;
    }

    public static void main(String[] args) {
        // Your specific example
        int[] nums = {4,5,6,7,0,1,2};
        int pivotIndex = findPivot(nums);

        System.out.println("The pivot index is: " + pivotIndex);
        System.out.println("The element at pivot is: " + nums[pivotIndex]);
    }

    static int findPivotMinimumWithDuplicates(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Case 1: drop found
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid + 1; // minimum element
            }

            // Case 2: mid itself is minimum
            if (mid > start && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            // duplicates case
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {

                if (start < end && nums[start] > nums[start + 1]) {
                    return start + 1;
                }
                start++;

                if (end > start && nums[end] < nums[end - 1]) {
                    return end;
                }
                end--;
            }

            // left side sorted
            else if (nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) {
                start = mid + 1;
            }

            // right side sorted
            else {
                end = mid - 1;
            }
        }

        return 0;
    }
}

