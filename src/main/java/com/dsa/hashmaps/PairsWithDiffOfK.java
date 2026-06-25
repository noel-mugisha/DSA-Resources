package com.dsa.hashmaps;

import java.util.HashSet;
import java.util.Set;

public class PairsWithDiffOfK {
    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3, 10};
        System.out.println(findPairs(arr, 4));
    }

    public static int findPairs (int[] nums, int k) {
        int count = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num - k))
                count++;
            if (set.contains(num + k))
                count++;
            set.add(num);
        }

        return count;
    }
}
