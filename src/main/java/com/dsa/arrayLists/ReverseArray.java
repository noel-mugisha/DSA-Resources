package com.dsa.arrayLists;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,23,45,56,78,2};
        System.out.println(Arrays.toString(reverseArray(arr)));
    }

    static int[] reverseArray(int[] array) {
        int start = 0;
        int end = array.length-1;
         while (start < end) {
             swap(array, start, end);
             start++;
             end--;
         }
         return array;
    }

    private static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
