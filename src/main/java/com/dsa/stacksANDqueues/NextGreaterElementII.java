package com.dsa.stacksANDqueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        int n = nums.length;
        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                int popped = stack.pop();
                res[popped] = nums[i % n];
            }
            stack.push(i % n);
        }

        return res;
    }
}
