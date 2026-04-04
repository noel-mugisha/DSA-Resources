package com.dsa.BinarySearch;

public class BinarySearchAlgo {
    public static void main(String[] args) {
        int[] nums = {1,23,45,67,89,100,214};
        System.out.println(binarySearch(nums, 214)); //7
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        return -1;
    }

    static int orderAgnosticBS (int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
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

