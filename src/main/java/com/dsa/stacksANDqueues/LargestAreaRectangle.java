package com.dsa.stacksANDqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestAreaRectangle {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1)
            return heights[0];

        int maxHeight = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i <= heights.length; i++) {
            int currH = (i == heights.length) ? -1 : heights[i];
            while (!stack.isEmpty() && currH < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int wid = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                maxHeight = Math.max(maxHeight, height * wid);
            }
            stack.push(i);
        }

        return maxHeight;
    }
}
