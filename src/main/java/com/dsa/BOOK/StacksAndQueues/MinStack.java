package com.dsa.BOOK.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }

    public void push(int value) {
        stack.push(value);
        if (minStack.isEmpty())
            minStack.push(value);
        else {
            if (value < minStack.peek())
                minStack.push(value);
            else
                minStack.push(minStack.peek());
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
