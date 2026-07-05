package com.dsa.BOOK.ArraysAndStrings;

public class StringCompression {

    public String compressString (String str) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            char c = Character.toLowerCase(str.charAt(i));
            int charCount = 0;
            while (i < str.length() && c == str.charAt(i)) {
                charCount++;
                i++;
            }
            sb.append(c).append(charCount);
        }

        return sb.length() < str.length() ? sb.toString() : str;
    }
}
