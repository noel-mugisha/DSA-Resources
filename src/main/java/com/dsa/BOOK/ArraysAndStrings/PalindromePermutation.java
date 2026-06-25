package com.dsa.BOOK.ArraysAndStrings;

public class PalindromePermutation {

    boolean isPermutationOfPalindrome(String phrase) {
        int[] letters = new int[26];

        for (char chr : phrase.toCharArray()) {
            if (Character.isLetter(chr)) {
                char c = Character.toLowerCase(chr);
                letters[c - 'a']++;
            }
        }

        int oddCount = 0;

        for (int num : letters) {
            if (num % 2 != 0)
                oddCount++;
        }

        return oddCount <= 1;
    }
}
