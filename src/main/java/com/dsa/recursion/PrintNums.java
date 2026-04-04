package com.dsa.recursion;

public class PrintNums {

    public static void main(String[] args) {
//        printNums(5);
        printNums2(5);
    }

    static void printNums (int n) {
        if (n < 1) {
            return;
        }
        System.out.print(n + " ");
        printNums(n-1);
    }

    static void printNums2 (int n) {
        if (n == 0)
            return;
        printNums2(n-1);

        System.out.print(n + " ");
    }
}
