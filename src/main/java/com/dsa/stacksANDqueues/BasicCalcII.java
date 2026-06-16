package com.dsa.stacksANDqueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalcII {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i <= s.length(); i++) {
            char c = i == s.length() ? '+' : s.charAt(i);
            if (c == ' ') continue;
            if (!Character.isDigit(c)) {
                if (sign == '+')
                    stack.push(num);
                else if (sign == '-')
                    stack.push(num * -1);
                else if (sign == '*')
                    stack.push(stack.pop() * num);
                else
                    stack.push(stack.pop() / num);

                num = 0; sign = c;
            } else {
                num = (num * 10) + c - '0';
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
