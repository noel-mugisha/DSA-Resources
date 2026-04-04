package com.dsa.arrayLists;

import java.util.Arrays;

public class FindMax {
    public static void main(String[] args) {
        int[] arr = {23, 26, 4, 19, 20};
//        List<Integer> list = new ArrayList<>();
//        System.out.println(findMaxValueIndex(arr));
        System.out.println(Arrays.toString(arr));
    }

    static int findMaxValue(int[] array) {
        int temp = array[0];
        for (int j : array) {
            if (j > temp)
                temp = j;
        }
        return temp;
    }

    static int findMaxValueIndex(int[] array) {
        int temp = array[0];
        int index = 0;
        for (int j : array) {
            if (j > temp) {
                temp = j;
                index++;
            }
        }
        return index;

    }
}
