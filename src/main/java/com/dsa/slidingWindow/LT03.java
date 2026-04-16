package com.dsa.slidingWindow;

public class LT03 {

    static int lengthOfLongestSubstring(String s) {
        int longestLength = 0;

        for (int i = 0; i < s.length(); i++) {
            String sbs = "";
            for (int j = i; j < s.length(); j++) {
                char current = s.charAt(j);
                if (sbs.indexOf(current) != -1)
                    break;
                sbs += current;
                longestLength = Math.max(longestLength, j - i + 1);
            }
        }

        return longestLength;
    }
}
