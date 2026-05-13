package com.dsa.BinarySearch;

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(findSqrt(31345));
    }
    static int findSqrt (int num) {
        if (num == 0 || num == 1) return num;
        int low = 1, high = num;
        int answ = 0;
        while (low <= high) {
            int mid = low + (high - low)/2;
            long square = (long) mid * mid;

            if (square == num)
                return mid;
            if (square < num) {
                answ = mid;
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return answ;
    }
}
