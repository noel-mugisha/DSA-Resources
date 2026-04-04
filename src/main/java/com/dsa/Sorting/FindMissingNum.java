package com.dsa.Sorting;

public class FindMissingNum {
    static int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correctIndex = nums[i];
            if (nums[i] < n && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else
                i++;
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j)
                return j;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }
}
