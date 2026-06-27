package com.dsa.slidingWindow;

public class ProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0)
            return 0;
        int ans = 0, product = 1;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            product *= nums[j];

            while (product >= k && i <= j) {
                product /= nums[i];
                i++;
            }

            ans += j - i + 1;
        }

        return ans;
    }
}
