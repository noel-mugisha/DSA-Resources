package com.dsa.BOOK.ArraysAndStrings;

public class IsStringPermutation {

    boolean permutation(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] isPerm = new int[128];

        for (char c : s.toCharArray())
            isPerm[c] ++;

        for (char c : t.toCharArray())
            isPerm[c] --;

        for (int num : isPerm) {
            if (num != 0)
                return false;
        }

        return true;
    }
}
