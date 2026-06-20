package com.dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class ContigArr {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            counter += nums[i] == 1 ? 1 : -1;

            if (map.containsKey(counter))
                maxLen = Math.max(maxLen, i - map.get(counter));

            else
                map.put(counter, i);
        }

        return maxLen;
    }
}
