package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(arr, target));
    }

    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int i = 0;
        int n = candidates.length;
        backtrack(candidates, i, n, current, subsets, target);
        return subsets;
    }

    static void backtrack(int[] nums, int i , int n, List<Integer> current, List<List<Integer>> subsets, int remaining) {
        if (remaining == 0) {
            subsets.add(new ArrayList<>(current));
            return;
        }
        if (remaining < 0) return;
        if (i == n) return;

        current.add(nums[i]);
        backtrack(nums, i+1 , n, current, subsets, remaining-nums[i]);

        current.removeLast();

        int j = i+1;
        while (j < n && nums[j] == nums[i]) {
            j++;
        }
        backtrack(nums, j, n, current, subsets, remaining);
    }
}
