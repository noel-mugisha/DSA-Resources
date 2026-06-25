package com.dsa.BOOK.ArraysAndStrings;

import java.util.Arrays;

public class PrintPermutations {
    public static void main(String[] args) {
        String s = "abbc";
        String b = "cbabadcbbabbcbabaabccbabc";

        findPermutations(s, b);
    }

    public static void findPermutations (String s, String b) {
        int[] sArr = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sArr[s.charAt(i) - 'a'] ++;
            window[b.charAt(i) - 'a'] ++;
        }

        if (Arrays.equals(sArr, window))
            System.out.println(b.substring(0, s.length()));

        int l = 0;

        for (int r = s.length(); r < b.length(); r++) {
            window[b.charAt(r) - 'a']++;
            window[b.charAt(l) - 'a']--;

            l++;

            if (Arrays.equals(sArr, window))
                System.out.println(b.substring(l, r + 1));
        }
    }
}
