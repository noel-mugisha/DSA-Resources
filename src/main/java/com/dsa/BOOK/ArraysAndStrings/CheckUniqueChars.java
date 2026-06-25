package com.dsa.BOOK.ArraysAndStrings;

public class CheckUniqueChars {

    boolean isUniqueChars(String s) {
        if (s.length() > 128)
            return false;

        boolean[] isSeen = new boolean[128];

        for (char c : s.toCharArray()) {
            if (isSeen[c])
                return false;

            isSeen[c] = true;
        }

        return true;
    }

}
