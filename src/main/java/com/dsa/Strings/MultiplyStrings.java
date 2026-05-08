package com.dsa.Strings;

public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(multiply("56", "12")); // "56088"
    }

    static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

       StringBuilder result = new StringBuilder();
       int[] resultArr = new int[num1.length() + num2.length()];
       // j for num 2, i for num1;
       for (int j = num2.length()-1; j >= 0; j--) {
           int dig2 = num2.charAt(j) - '0';
           for (int i = num1.length()-1; i >= 0; i--) {
               int dig1 = num1.charAt(i) - '0';
               int pos1 = i + j, pos2 = i +j +1;
               int sum = (dig1 * dig2) + resultArr[pos2];
               resultArr[pos2] = sum % 10;
               resultArr[pos1] += sum / 10;
           }
       }

        for (int dig : resultArr) {
           if (result.isEmpty() && dig == 0)
               continue;
           result.append(dig);
       }
       return result.toString();
    }
}
