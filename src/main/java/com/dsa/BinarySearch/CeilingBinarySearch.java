package com.dsa.BinarySearch;

public class CeilingBinarySearch {
    public static void main(String[] args) {
        int[] nums = {2,3,5,9,14,16,18};
        int target = 8;
        int answer = findCeiling(nums, target);
//        int answer = findFloor(nums, target);
        System.out.println(answer);
    }

    static int findCeiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        if (target > arr[end])
            return -1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (target == arr[mid]) {
                return arr[mid];
            } else if (target < arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return arr[start];
    }

    static int findFloor(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        if (target < arr[start])
            return -1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (target == arr[mid]) {
                return arr[mid];
            } else if (target < arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return arr[end];
    }
}
