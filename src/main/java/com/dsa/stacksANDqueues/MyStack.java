package com.dsa.stacksANDqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
    private Deque<Integer> queue;
    private Deque<Integer> helperQueue;

    public MyStack() {
        queue = new ArrayDeque<>();
        helperQueue = new ArrayDeque<>();
    }

    public void push(int x) {
        helperQueue.offer(x);
        while (!queue.isEmpty()) {
            helperQueue.offer(queue.poll());
        }
        Deque<Integer> temp = queue;
        queue = helperQueue;
        helperQueue = temp;
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}
