package com.dsa.TwoPointer;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;
        int left = 0, right = nums.length - 1;
        int i = 0;

        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 1)
                i++;
            else {
                swap(nums, i, right);
                right--;
            }
        }
    }

    void swap (int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
