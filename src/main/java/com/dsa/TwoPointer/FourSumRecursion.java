package com.dsa.TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumRecursion {
    public static void main(String[] args) {
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(fourSum(nums1, 0));
        System.out.println(fourSum(nums2, 8));
    }

    static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        helper(nums, (long) target, 0, current, res, 4);
        return res;
    }

    static void helper(int[] nums, long target, int start, List<Integer> current, List<List<Integer>> res, int k) {
        if (k != 2) {
            for (int i = start; i <= nums.length - k; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                current.add(nums[i]);
                helper(nums, target - nums[i], i + 1, current, res, k - 1);
                current.removeLast();
            }
            return;
        }
        int left = start, right = nums.length - 1;

        while (left < right) {
            long sum = (long) nums[left] + nums[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                // FIXED: Do not modify the shared 'current' list. Create a new one.
                List<Integer> validQuadruplet = new ArrayList<>(current);
                validQuadruplet.add(nums[left]);
                validQuadruplet.add(nums[right]);
                res.add(validQuadruplet);

                left++;
                right--;

                while (left < right && nums[left] == nums[left - 1]) left++;
                while (left < right && nums[right] == nums[right + 1]) right--;
            }
        }
    }
}