package com.dsa.recursion;

public class Reverse {
    static int reverseNum (int n) {
        if (n/10 == 0)
            return n;
        System.out.print(n%10);

        return reverseNum(n/10);
    }

    public static void main(String[] args) {
//        System.out.println(reverseNum(129));
        int i = 1;
        System.out.println(i++);
        System.out.println(++i);
    }
}
