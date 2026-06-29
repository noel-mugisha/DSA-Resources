package com.dsa.arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;

        // build left product
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // add right product
        int rightProd = 1;
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= rightProd;
            rightProd *= nums[j];
        }

        return res;
    }
}
