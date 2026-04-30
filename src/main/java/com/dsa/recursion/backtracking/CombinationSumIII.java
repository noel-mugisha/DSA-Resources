package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = i+1;
        }
        List<List<Integer>> combinations = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int i = 0;
        backtrack(nums, i, k, n, current, combinations);
        return combinations;
    }

    static void backtrack(int[] nums, int i, int k , int remaining, List<Integer> current, List<List<Integer>> combinations) {
        if (current.size() == k) {
            if (remaining == 0)
                combinations.add(new ArrayList<>(current));
            return;
        }
        if (i == nums.length) return;

        if (nums[i] > remaining) return;
        current.add(nums[i]);
        backtrack(nums, i+1, k, remaining-nums[i], current, combinations);

        current.removeLast();
        backtrack(nums, i+1, k, remaining, current, combinations);
    }
}
