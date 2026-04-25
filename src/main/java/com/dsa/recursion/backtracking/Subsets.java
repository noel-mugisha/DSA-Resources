package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(returnSubsets(arr));
    }

    static List<List<Integer>> returnSubsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int i = 0;
        int n = arr.length;
        backtrack (arr, i, n, current, subsets);
        return subsets;
    }

    static void backtrack(int[] arr, int i, int n, List<Integer> current, List<List<Integer>> subsets) {
        if (i == n) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        current.add(arr[i]);
        backtrack(arr, i+1, n, current, subsets);

        current.removeLast();
        backtrack(arr, i+1, n, current, subsets);
    }

}
