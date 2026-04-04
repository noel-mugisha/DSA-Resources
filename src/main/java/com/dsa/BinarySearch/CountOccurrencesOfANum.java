package com.dsa.BinarySearch;

public class CountOccurrencesOfANum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,5,5,6,7,8,12,12};
        System.out.println(findOccurrences(nums, 12));
    }
    static int findOccurrences(int[] arr, int target) {
        int firstIndex = findFirstOccurrence(arr, target);
        System.out.println(firstIndex);
        int lastIndex = findLastOccurrence(arr, target);
        System.out.println(lastIndex);
        return (lastIndex-firstIndex) + 1;
    }
    static int findFirstOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int answ = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid]==target) {
                answ = mid;
                end = mid-1;
            } else if (arr[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return answ;
    }
    static int findLastOccurrence(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int answ = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid]==target) {
                answ = mid;
                start = mid+1;
            } else if (arr[mid] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        return answ;
    }
}
