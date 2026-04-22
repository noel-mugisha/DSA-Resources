package com.dsa.greedy;

import java.util.Arrays;

public class MaxNoOfThings {
    public static void main(String[] args) {
        int[] arr = {5};
        int time = 6;

        System.out.println(returnMaxNoOfThings(arr, time));
    }

    static int returnMaxNoOfThings(int[] arr, int time) {
        int nOfThings = 1;

        if (arr.length < 2){
            if (arr[0] > time) {
                return 0;
            }
            else return nOfThings;
        }

        Arrays.sort(arr);

        int currentTime = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currentTime + arr[i] > time)
                break;
            else {
                currentTime += arr[i];
                nOfThings++;
            }
        }

        return nOfThings;
    }
}
