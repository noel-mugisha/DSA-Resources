package com.dsa.stacksANDqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : operations) {
            switch (s) {
                case "+" -> {
                    int popped = stack.pop();
                    int peeked = stack.peek();
                    stack.push(popped);
                    stack.push(popped + peeked);
                }

                case "D" -> {
                    int value = stack.peek() * 2;
                    stack.push(value);
                }

                case "C" -> stack.pop();

                default -> stack.push(Integer.parseInt(s));
            }
        }

        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();

        return sum;
    }

    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(c);
            else{
                if (stack.isEmpty() || stack.peek() != '(') {
                    stack.push(c);
                }
                else
                    stack.pop();
            }
        }

        return stack.size();
    }


}
