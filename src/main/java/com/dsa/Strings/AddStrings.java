package com.dsa.Strings;

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("0", "99"));
    }
    static String addStrings(String num1, String num2) {
        if (num1 .equals("0")) return num2;
        if (num2 .equals("0")) return num1;

        StringBuilder sum = new StringBuilder();
        int i = num1.length()-1, j = num2.length()-1;
        int carry = 0;
        while (i >=0 || j>=0 || carry != 0) {
            int dig1 = (i < 0) ? 0 : num1.charAt(i) - '0';
            int dig2 = (j < 0) ? 0 : num2.charAt(j) - '0';
            int inSum = dig1 + dig2 + carry;
            carry = inSum / 10;
            sum.append(inSum % 10);
            i--;
            j--;
        }

        return sum.reverse().toString();
    }
}
