package com.dsa.slidingWindow;

public class MaxPointsFromCards {

    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    static int maxScore(int[] cardPoints, int k) {
        int rsum = 0, lsum = 0;

        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }

        int maxSum = lsum;
        int lastIndex = cardPoints.length - 1;

        for (int j = k - 1; j >= 0; j--) {
            lsum -= cardPoints[j];
            rsum += cardPoints[lastIndex];
            maxSum = Math.max(maxSum, lsum + rsum);
            lastIndex--;
        }

        return maxSum;
    }
}
