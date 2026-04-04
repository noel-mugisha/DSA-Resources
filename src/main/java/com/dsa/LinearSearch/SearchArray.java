package com.dsa.LinearSearch;

public class SearchArray {
    public static void main(String[] args) {
        int[] array = {1,2,3,45,67,89};
        int result = search(array, 89);
        System.out.println(result);
    }

    static int search (int[] arr, int target) {
        int index = 0;
        for (int j : arr) {
            if (j == target) {
                return index;
            }
            index ++;
        }
        return -1;
    }
}
