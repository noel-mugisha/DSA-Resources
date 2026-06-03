package com.dsa.TwoPointer;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return  false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arr1, arr2))
            return true;

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            arr2[s2.charAt(left) - 'a']--;
            arr2[s2.charAt(right) - 'a']++;
            if (Arrays.equals(arr1, arr2))
                return true;
            left++;
        }

        return false;
    }
}
