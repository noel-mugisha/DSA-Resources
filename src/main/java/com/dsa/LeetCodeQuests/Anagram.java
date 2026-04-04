package com.dsa.LeetCodeQuests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    public static void main(String[] args) {
        int[] arr = new int[26];
        Arrays.fill(arr, Integer.MAX_VALUE);
        System.out.println(Arrays.toString(arr));
    }

    static boolean isAnagram (String s, String t) {
        if (t.length() != s.length()) return false;

        int[] arr = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        for (char c : sArr) {
            arr[c - 'a'] ++;
        }

        for (char c : tArr) {
            arr[c - 'a'] --;
        }

        for (int n : arr) {
            if (n != 0)
                return false;
        }

        return true;
    }
}
