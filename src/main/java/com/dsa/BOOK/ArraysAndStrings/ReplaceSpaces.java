package com.dsa.BOOK.ArraysAndStrings;

public class ReplaceSpaces {

    public static void main(String[] args) {
        String s = "Mr John Smith             ";
        char[] arr = s.toCharArray();
        replaceSpaces(arr, 13);
        System.out.println(new String(arr));
    }

    // Given a String like "Mr John Smith             " and the length without extra buffer
    // Output should be "Mr%20John%20Smith"
    static void replaceSpaces (char[] str, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (str[i] == ' ')
                spaceCount++;
        }

        int lastIndex = (trueLength + (spaceCount * 2)) - 1;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[lastIndex] = '0';
                str[lastIndex - 1] = '2';
                str[lastIndex - 2] = '%';

                lastIndex -= 3;
            } else {
                str[lastIndex] = str[i];
                lastIndex--;
            }
        }
    }
}
