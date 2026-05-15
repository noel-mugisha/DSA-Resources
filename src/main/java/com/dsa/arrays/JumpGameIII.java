package com.dsa.arrays;

public class JumpGameIII {
    public static void main(String[] args) {
        int[] nums1 = {4,2,3,0,3,1,2};
        int[] nums2 = {3,0,2,1,2};
        System.out.println(canReach(nums1, 5));
        System.out.println(canReach(nums2, 2));
    }

    static boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0)
            return false;
        if (arr[start] == 0)
            return true;

        int temp = arr[start];
        arr[start] *= -1;

        boolean foudZero = canReach(arr,start + temp)
                || canReach(arr, start - temp);

        arr[start] = temp;

        return foudZero;
    }
}
