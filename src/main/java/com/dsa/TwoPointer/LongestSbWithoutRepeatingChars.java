package com.dsa.TwoPointer;

import java.util.HashSet;
import java.util.Set;

public class LongestSbWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0;
        Set<Character> window = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (window.contains(s.charAt(right))) {
                window.remove(s.charAt(left));
                left ++;
            }
            window.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
