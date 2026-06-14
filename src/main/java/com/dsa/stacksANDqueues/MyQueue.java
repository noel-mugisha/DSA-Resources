package com.dsa.stacksANDqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    private Deque<Integer> stack;
    private Deque<Integer> helperStack;

    public MyQueue() {
        stack = new ArrayDeque<>();
        helperStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        moveInto(stack, helperStack);
        int num = helperStack.pop();
        moveInto(helperStack, stack);
        return num;
    }

    public int peek() {
        moveInto(stack, helperStack);
        int num = helperStack.peek();
        moveInto(helperStack, stack);
        return num;
    }

    public boolean empty() {
        return stack.size() == 0;
    }

    private void moveInto (Deque<Integer> stack1, Deque<Integer> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
