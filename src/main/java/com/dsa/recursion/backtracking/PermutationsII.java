package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutes = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        backtrack (nums, isUsed, current, permutes);
        return permutes;
    }

    public void backtrack(int[] nums, boolean[] isUsed, List<Integer> current, List<List<Integer>> permutes) {
        if (current.size() == nums.length) {
            permutes.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !isUsed[i-1]) continue;

            current.add(nums[i]);
            isUsed[i] = true;
            backtrack(nums, isUsed, current, permutes);

            current.removeLast();
            isUsed[i] = false;
        }
    }
}






























