package com.dsa.LinearSearch;

public class MaxWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                {11,5},
                {7,3},
                {3,5}
        };

        System.out.println(maximumWealth(accounts));

    }

    static int maximumWealth (int[][]accounts) {
        int [] sums = findIndividualSums(accounts);
        int biggestSum = sums[0];
        for (int sum : sums) {
            if (sum > biggestSum)
                biggestSum = sum;
        }
        return biggestSum;
    }

    static int[] findIndividualSums(int[][] accounts) {
        int[] resultArr = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            resultArr[i] = sum;
        }
        return resultArr;
    }
}
