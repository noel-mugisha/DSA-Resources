package com.dsa.BinarySearch;

public class MedianOfSortedArrs {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int totalen = (m + n + 1) / 2;
        int start = 0, end = m;

        while (start <= end) {
            int cut1 = start + (end - start) / 2;
            int cut2 = totalen - cut1;

            int maxLeft1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int minRight1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int maxLeft2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int minRight2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0) {
                    double maxLeft = (double) (Math.max(maxLeft1, maxLeft2));
                    int minRight = Math.min(minRight1, minRight2);
                    return (maxLeft + minRight) / 2;
                }
                return Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) {
                end = cut1 - 1;
            } else {
                start = cut1 + 1;
            }
        }
        return -1.0;
    }
}
