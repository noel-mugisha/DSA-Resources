package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(arr, target));
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        if (i == n) return;
        if (nums[i] > remaining) return;

        current.add(nums[i]);
        backtrack(nums, i , n, current, subsets, remaining-nums[i]);

        current.removeLast();
        backtrack(nums, i+1, n, current, subsets, remaining);
    }
}























