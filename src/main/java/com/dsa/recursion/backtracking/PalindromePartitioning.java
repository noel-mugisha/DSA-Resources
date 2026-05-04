package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> current = new ArrayList<>();
        int start = 0;
        backtrack(s, start, current, partitions);
        return partitions;
    }

    void backtrack(String s, int start, List<String> current, List<List<String>> partitions) {
        if (start == s.length()) {
            partitions.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end+1));
                backtrack(s, end+1, current, partitions);
                current.removeLast();
            }
        }
    }

    boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
