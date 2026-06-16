package com.dsa.stacksANDqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String s : tokens) {
            boolean isOperator = s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
            if (isOperator) {
                int num1 = stack.pop(), num2 = stack.pop();
                switch (s) {
                    case "+" -> stack.push(num2 + num1);
                    case "-" -> stack.push(num2 - num1);
                    case "*" -> stack.push(num2 * num1);
                    default -> stack.push(num2 / num1);
                }
            }
            else
                stack.push(Integer.parseInt(s));
        }

        return stack.peek();
    }
}
