package com.dsa.BOOK.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SetOfStacks {
    private List<Deque<Integer>> setOfStacks;
    private int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
        this.setOfStacks = new ArrayList<>();
    }

    public void push(int value) {
        if (setOfStacks.isEmpty() || isFull()) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(value);
            setOfStacks.add(stack);
        } else {
            setOfStacks.getLast().push(value);
        }
    }

    public int pop() {
        if (setOfStacks.isEmpty())
            throw new IllegalArgumentException("Can't pop in an empty stack");

        var stack = setOfStacks.getLast();
        int value = stack.pop();

        if (stack.isEmpty())
            setOfStacks.removeLast();

        return value;
    }

    public int popAtIndex(int index) {
        if (setOfStacks.isEmpty())
            throw new IllegalArgumentException("Can't pop in an empty stack");

        var stack = setOfStacks.get(index);
        int value = stack.pop();

        if (stack.isEmpty())
            setOfStacks.remove(index);

        return value;
    }

    private boolean isFull() {
        return this.setOfStacks.getLast().size() == this.capacity;
    }
}
