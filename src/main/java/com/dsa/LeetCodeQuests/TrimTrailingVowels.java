package com.dsa.LeetCodeQuests;

public class TrimTrailingVowels {
    public static void main(String[] args) {
        String word = "aeioubu";
        String answer = trimTrailingVowels(word);
        System.out.println("\"" + answer + "\"");
    }

    static String trimTrailingVowels(String s) {
        StringBuilder result = new StringBuilder();
        int lastConsonantIndex = findLastConsonantIndex(s);
        if (lastConsonantIndex == -1)
            return "";
        for (int i = 0; i <= lastConsonantIndex; i++) {
            char c = s.charAt(i);
            result.append(c);
        }
        return result.toString();
    }

    static int findLastConsonantIndex(String word) {
        int i = word.length()-1;
        while (i >= 0) {
            char c = word.charAt(i);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                return i;
            }
            i--;
        }
        return -1;
    }
}
