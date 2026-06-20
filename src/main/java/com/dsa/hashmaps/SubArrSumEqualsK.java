package com.dsa.hashmaps;

import java.util.HashMap;
import java.util.Map;

public class SubArrSumEqualsK {

    // Optimized code
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, prefSum = 0;
        map.put(0, 1);

        for (int num : nums) {
            prefSum += num;

            if (map.containsKey(prefSum - k))
                count += map.get(prefSum - k);

            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }

        return count;
    }
}
