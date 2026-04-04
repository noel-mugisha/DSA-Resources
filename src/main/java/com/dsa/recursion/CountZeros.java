package com.dsa.recursion;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(countZeros(302104, 0));
        System.out.println(countZeros2(1230202));
    }

    static int countZeros (int number, int count) {
        if (number == 0)
            return count;

        if (number%10 == 0)
            count++;

        return countZeros(number/10, count);
    }

    static int countZeros2 (int n) {
        if (n == 0)
            return 1;
        int count = 0;

        return helper(n, count);
    }

    static int helper(int n, int count) {
        if (n/10 == 0)
            return count;

        if (n%10 == 0)
            count++;

        return helper(n/10, count);
    }
}
