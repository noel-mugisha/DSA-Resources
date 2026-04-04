package com.dsa.LinearSearch;

public class EvenDigitNums {
    public static void main(String[] args) {
        int[] numbers = {176869,3778645,2345,67888,78967886};
        System.out.println(findNumbers1(numbers)); // Output: 2
        System.out.println(findNumbers2(numbers));
    }

    public static int findNumbers1(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (Integer.toString(num).length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    public static int findNumbers2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int numOfDigits = findNumOfDigits(num);
            if (numOfDigits % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    private static int findNumOfDigits(int num) {
        int numOfDigs = 0;
        while (num > 0) {
            numOfDigs ++;
            num /= 10;
        }
        return numOfDigs;
    }

}
