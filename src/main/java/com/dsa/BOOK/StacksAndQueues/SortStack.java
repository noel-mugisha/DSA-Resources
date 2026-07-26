package com.dsa.BOOK.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SortStack {

    public void sort(Deque<Integer> stack) {
        Deque<Integer> sortedStack = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            int value = stack.pop();
            int len = 0;

            while (!sortedStack.isEmpty() && value > sortedStack.peek()) {
                len++;
                stack.push(sortedStack.pop());
            }

            sortedStack.push(value);
            for (int i = 0; i < len; i++) {
                sortedStack.push(stack.pop());
            }
        }

        stack.addAll(sortedStack);
    }
}
