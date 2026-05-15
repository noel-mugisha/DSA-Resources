package com.dsa.arrays;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {2,3,0,1,4};
        System.out.println(jump(nums1));
        System.out.println(jump(nums2));
    }

    static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int minJumps = 0, currentEnd = 0, farthest = 0;

        for (int i = 0; i < nums.length-1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                minJumps++;
                currentEnd = farthest;
            }

            if (currentEnd >= nums.length-1)
                break;
        }

        return minJumps;
    }
}
