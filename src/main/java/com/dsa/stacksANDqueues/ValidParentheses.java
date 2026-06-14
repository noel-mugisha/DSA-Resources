package com.dsa.stacksANDqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;
                char ch = stack.peek();
                if (c == '}' && ch != '{') return false;
                if (c == ']' && ch != '[') return false;
                if (c == ')' && ch != '(') return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
