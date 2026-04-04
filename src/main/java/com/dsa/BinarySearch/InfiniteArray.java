package com.dsa.BinarySearch;

public class InfiniteArray {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7,8,9,10,11,12,14,26,57,67,78,89};
        System.out.println(searchInfiniteArray(nums,5));
    }

    static int searchInfiniteArray (int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int newStart = end + 1;
            int size = (end - start + 1) * 2;
            end = end + size;
            start = newStart;
        }
        return binarySearch(arr, start, end, target);
    }

    static int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target)
                return mid;
            else if (target < arr[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return -1;
    }
}
