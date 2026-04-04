package com.dsa.LeetCodeQuests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1002 {

    static List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        int[] minFrequency = new int[26];
        Arrays.fill(minFrequency, Integer.MAX_VALUE);

        for (String word : words) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a'] ++;
            }

            for (int i = 0; i < minFrequency.length; i++) {
                minFrequency[i] = Math.min(minFrequency[i], count[i]);
            }
        }

        for (int i = 0; i < minFrequency.length; i++) {
            while (minFrequency[i] > 0) {
                String s = String.valueOf((char) (i + 'a'));
                result.add(s);
                minFrequency[i] --;
            }
        }

            return result;
    }
}
