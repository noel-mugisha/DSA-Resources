package com.dsa.maths;

public class EvenOddNums {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 5, 3, 4};
        System.out.println(onceInArr(nums));
    }

    static int onceInArr (int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    static String evenOrOdd (int n) {
        if ((n & 1) == 1)
            return "odd";
        return "even";
    }
}
