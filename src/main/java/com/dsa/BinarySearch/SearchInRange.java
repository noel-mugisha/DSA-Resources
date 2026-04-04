package com.dsa.BinarySearch;

import java.util.Arrays;

public class SearchInRange {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    static int[] searchRange(int[] nums, int target) {
        int firstOccurrence = searchFirst(nums, target);
        int lastOccurrence = searchLast(nums, target);
        return new int[] {firstOccurrence, lastOccurrence};
    }

    static int searchFirst (int[] arr, int target) {
        int answ = -1;
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (target == arr[mid]) {
                answ = mid;
                end = mid - 1; // here to change
            }
            else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answ;
    }

    static int searchLast (int[] arr, int target) {
        int answ = -1;
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (target == arr[mid]) {
                answ = mid;
                start = mid + 1; // here to change
            }
            else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answ;
    }
}
