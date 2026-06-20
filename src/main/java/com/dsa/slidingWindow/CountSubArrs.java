package com.dsa.slidingWindow;

public class CountSubArrs {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int maxEL = Integer.MIN_VALUE;
        for (int num : nums)
            maxEL = Math.max(maxEL, num);

        int l = 0, count = 0;

        for (int num : nums) {
            if (num == maxEL)
                count++;

            while (count == k) {
                if (nums[l] == maxEL)
                    count--;
                l++;
            }

            res += l;
        }

        return res;
    }
}
