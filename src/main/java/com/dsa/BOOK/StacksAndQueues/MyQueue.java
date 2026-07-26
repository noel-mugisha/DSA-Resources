package com.dsa.BOOK.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    private Deque<Integer> stack;
    private Deque<Integer> helperStack;

    public MyQueue() {
        this.stack = new ArrayDeque<>();
        this.helperStack = new ArrayDeque<>();
    }

    public void offer(int value) {
        stack.push(value);
        while (!stack.isEmpty()) {
            helperStack.push(stack.pop());
        }

        Deque<Integer> temp = new ArrayDeque<>();
        stack = helperStack;
        helperStack = temp;
    }

    public int peek() {
        return stack.peek();
    }

    public int poll() {
        return stack.pop();
    }
}
