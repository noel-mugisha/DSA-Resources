package com.dsa.hashmaps;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int len = 0;
                while (set.contains(num + len))
                    len++;
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
