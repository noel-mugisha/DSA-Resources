package com.dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArrWithKDistinctInts {
    // we use a hashmap and count occurrences and add n of subarrays
    // we use j-i+1, and they are asking exactly k integers
    // for exactly we use atmost(k) - atmost(k-1)
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    int atMost(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0, i = 0;

        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0)
                    map.remove(nums[i]);
                i++;
            }

            ans += j - i + 1;
        }

        return ans;
    }
}
