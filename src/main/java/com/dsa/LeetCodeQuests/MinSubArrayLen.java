package com.dsa.LeetCodeQuests;

public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
}
    static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0, left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                int len = right - left + 1;
                minLen = Math.min(minLen, len);
                sum -= nums[left];
                left++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}
