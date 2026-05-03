package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
    public static void main(String[] args) {
        String s = "23";
        System.out.println(letterCombinations(s));
    }

    static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) return combinations;
        String[] arr = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        StringBuilder current = new StringBuilder();
        int i = 0;
        backtrack(digits, arr, i, current, combinations);
        return combinations;
    }

    static void backtrack(String digits, String[] arr, int i, StringBuilder current, List<String> combinations) {
        if (i == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        String letters = arr[digits.charAt(i) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, arr, i+1, current, combinations);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
