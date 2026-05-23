package com.dsa.recursion.quests;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutations {
    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
    }

    static List<String> letterCasePermutation(String s) {
        List<String> permutes = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtrack(s, 0, current, permutes);
        return permutes;
    }

    static void backtrack(String s, int i, StringBuilder current, List<String> permutes) {
        if (current.length() == s.length()) {
            permutes.add(current.toString());
            return;
        }

        char value = s.charAt(i);

        if (Character.isDigit(value)) {
            current.append(value);
            backtrack(s, i+1, current, permutes);
            current.deleteCharAt(current.length()-1);
        } else {
            current.append(Character.toLowerCase(value));
            backtrack(s, i+1, current, permutes);
            current.deleteCharAt(current.length()-1);

            current.append(Character.toUpperCase(value));
            backtrack(s, i+1, current, permutes);
            current.deleteCharAt(current.length()-1);
        }
    }
}
