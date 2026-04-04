package com.dsa.BinarySearch;

public class FirstOccurenceInInfinteArray {
    public static void main(String[] args) {

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
        int answ = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] == target){
                answ = mid;
                end = mid-1;
            }
            else if (target < arr[mid])
                end = mid-1;
            else
                start = mid+1;
        }
        return answ;
    }
}
