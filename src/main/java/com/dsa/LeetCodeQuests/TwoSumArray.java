package com.dsa.LeetCodeQuests;

import java.util.Arrays;

public class TwoSumArray {
    public static void main(String[] args) {
        int[] nums = new int[] {3,2,4};
        var answer = twoSum(nums, 6);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0; i<=nums.length-1; i++) {
            for (int j = nums.length-1; j>i; j--){
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }

            }
        }
        // if there isn't any
        result[0] = -1;
        result[1] = -1;
        return result;
    }

}
