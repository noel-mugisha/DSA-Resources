package com.dsa.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentEls {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for (int j = buckets.length - 1; j >= 0; j--) {
            if (buckets[j].isEmpty())
                continue;

            for (Integer num : buckets[j]) {
                result[index] = num;
                index++;
                if (index == k)
                    return result;
            }
        }

        return  result;
    }
}
