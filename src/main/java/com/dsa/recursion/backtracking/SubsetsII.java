package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static void main(String[] args) {;
        int[] arr = {1,2,2,3};
        System.out.println(subsetsWithDup(arr));
    }

    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        backtrack(nums, i , n, current, result);
        return result;
    }

    static void backtrack(int[] nums, int i , int n , List<Integer> current, List<List<Integer>> subsets) {
        if (i == n) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        backtrack(nums, i+1, n, current, subsets);

        current.removeLast();

        int j = i+1;
        while (j < n && nums[j] == nums[i]) {
            j++;
        }
        backtrack(nums, j, n, current, subsets);
    }
}
