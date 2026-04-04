package com.dsa.maths;

import java.util.Arrays;

public class PrimeNumbers {
    public static void main(String[] args) {
//        System.out.println(printPrimeNum(1000));
        printPrimeNumsUntil(53);
    }

    static int printPrimeNum(int number) {
        int count = 0;
        int start = 2;

        while (count < number) {
            if (isPrime(start)) {
                count++;
                start++;
            } else {
                start++;
            }
        }

        return start - 1;
    }

    static boolean isPrime(int n) {
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0)
                return false;
            i++;
        }
        return true;
    }

    static void printPrimeNumsUntil(int n) {
        boolean[] nums = new boolean[n + 1];
        Arrays.fill(nums, true);
        nums[0] = false;
        nums[1] = false;

        for (int i = 2; i*i <= n; i++) {
            for (int j = i*2; j <= n ; j+=i) {
                nums[j] = false;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i])
                System.out.print(i + " ");
        }
    }
}
