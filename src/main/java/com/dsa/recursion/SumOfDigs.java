package com.dsa.recursion;

public class SumOfDigs {
    public static void main(String[] args) {
        System.out.println(sumOfDigs(152));
    }

    static int sumOfDigs (int n) {
        if (n / 10 == 0)
            return n;

        int dig = n % 10;

        return dig + sumOfDigs(n / 10);
    }
}
