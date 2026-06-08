package com.dsa.LinkedLists;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        } while (slow != fast);

        return slow == 1;
    }

    int findSquare(int num) {
        int answ = 0;
        while (num > 0) {
            int rem = num % 10;
            answ += rem * rem;
            num /= 10;
        }
        return answ;
    }
}
