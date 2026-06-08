package com.dsa.TwoPointer;

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                waterTrapped += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                waterTrapped += rightMax - height[right];
                right--;
            }
        }

        return waterTrapped;
    }
}
