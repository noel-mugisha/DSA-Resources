package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        backtrack(nums, isUsed, current, result);
        return result;
    }

    static void backtrack(int[] nums, boolean[] isUsed, List<Integer> current, List<List<Integer>> permutes) {
        if (current.size() == nums.length) {
            permutes.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < isUsed.length; i++) {
            if (!isUsed[i]) {
                current.add(nums[i]);
                isUsed[i] = true;
                backtrack(nums, isUsed, current, permutes);

                current.removeLast();
                isUsed[i] = false;
            }
        }
    }
}
