package com.dsa.recursion;

public class FindMaxNumber {

    public static void main(String[] args) {
        int[] arr = {70, 250, 50, 80, 140, 12, 14, 254};
        System.out.println("Max: " + findMaxNumber(arr));
        System.out.println("Min: " + findMinNumber(arr));
    }

    static int findMaxNumber(int[] arr) {
        return helper(arr, 0, arr.length-1);
    }

    static int helper (int[] arr, int start, int end) {
        if (start == end) return arr[start];

        int mid = start + (end-start)/2;

        int left = helper(arr, start, mid);
        int right = helper(arr, mid+1, end);

        return Math.max(left, right);
    }

    static int findMinNumber(int[] arr) {
        return helperMin(arr, 0, arr.length-1);
    }

    static int helperMin(int[] arr, int start, int end) {
        if (start == end) return arr[start];

        int mid = start + (end-start)/2;

        int left = helperMin(arr, start, mid);
        int right = helperMin(arr, mid+1, end);

        return Math.min(left, right);
    }
}
