package com.dsa.LeetCodeQuests;

public class MountainArray {
    public static void main(String[] args) {
        int [] nums = {1,2,4,6,7,5,3,2,0};
        System.out.println(findFirstOccurrence(nums,2));
    }

    static int findFirstOccurrence(int[] arr, int target) {
        int peak = findPeak(arr);
        int firstOccurrence = orderAgnosticBS(arr, 0, peak, target);
        int lastOccurrence = orderAgnosticBS(arr, peak, arr.length -1, target);

        if (firstOccurrence != -1)
            return firstOccurrence;
        return lastOccurrence;
    }

    static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) /2;
            if (arr[mid] > arr[mid+1])
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    static int orderAgnosticBS (int[] arr, int start, int end, int target) {
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid])
                return mid;
            if (isAsc) {
                if (arr[mid] < target)
                    start = mid+1;
                else
                    end = mid-1;
            } else {
                if (arr[mid] < target)
                    end = mid-1;
                else
                    start = mid+1;
            }
        }
        return -1;
    }


}
