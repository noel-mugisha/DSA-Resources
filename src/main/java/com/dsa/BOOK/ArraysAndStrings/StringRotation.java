package com.dsa.BOOK.ArraysAndStrings;

public class StringRotation {

    // We are checking if s2 is a rotation of s1
    public boolean isRotation (String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s2.length() <= 1)
            return true;

        int breakingIndex = 1;

        while (breakingIndex < s2.length()) {
            if (!isSubstring(s1, s2.substring(0, breakingIndex)))
                break;
            breakingIndex++;
        }

        return isSubstring(s1, s2.substring(breakingIndex - 1));
    }

    public boolean isSubstring (String s1, String s2) {
        return s1.contains(s2);
    }

    // Modern approach, yx is a substring of xyxy;
    public boolean checkRotation (String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        String s1s1 = s1 + s1;

        return isSubstring(s1s1, s2);
    }
}
