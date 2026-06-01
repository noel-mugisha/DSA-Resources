package com.dsa.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums1 = {1,0,-1,0,-2,2};
        int[] nums2 = {2,2,2,2,2};
        System.out.println(fourSum(nums1, 0));
        System.out.println(fourSum(nums2, 8));
    }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < n-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                int left = j + 1, right = n-1;
                while (left < right) {
                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        left ++;
                        right --;
                        while (left < right && nums[left] == nums[left-1]) left++;
                        while (left < right && nums[right] == nums[right+1]) right--;
                    } else if (sum < target)
                        left ++;
                    else
                        right --;
                }
            }
        }
        return res;
    }
}
