package com.dsa.recursion.MazeProblems;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

    static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return findUniquePaths(0, 0, m, n, dp);
    }

    static int findUniquePaths(int r, int c, int m, int n, int[][] dp) {
        if (r == m - 1 || c == n - 1)
            return 1;

        if (dp[r][c] != 0)
            return dp[r][c];

        int right = findUniquePaths(r, c + 1, m, n, dp);
        int down = findUniquePaths(r + 1, c, m, n, dp);

        return dp[r][c] = right + down;
    }
}
