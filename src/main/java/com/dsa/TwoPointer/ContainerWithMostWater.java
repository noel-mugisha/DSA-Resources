package com.dsa.TwoPointer;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, w * h);

            if (height[left] < height[right])
                left ++;
            else
                right --;
        }

        return maxArea;
    }
}
