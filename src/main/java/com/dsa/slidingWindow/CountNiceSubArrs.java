package com.dsa.slidingWindow;

public class CountNiceSubArrs {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    int atMost(int[] nums, int k) {
        int oddCount = 0, ans = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (isOdd(nums[j]))
                oddCount++;

            while (oddCount > k) {
                if (isOdd(nums[i]))
                    oddCount--;
                i++;
            }

            ans += j - i + 1;
        }

        return ans;
    }

    boolean isOdd (int num) {
        return num % 2 != 0;
    }
}
