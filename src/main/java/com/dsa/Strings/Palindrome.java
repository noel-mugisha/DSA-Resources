package com.dsa.Strings;

public class Palindrome {
    public static void main(String[] args) {
        int num = 121;
        System.out.println(checkPalindrome(num));
    }
    static boolean checkPalindrome(int num) {
        String numString = Integer.toString(num);
        String reversedString = new StringBuilder(numString).reverse().toString();
        return numString.equals(reversedString);
    }
}
