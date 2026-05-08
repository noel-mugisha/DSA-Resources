package com.dsa.recursion.MazeProblems;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rl = obstacleGrid.length;
        int cl = obstacleGrid[0].length;
        Integer[][] dp = new Integer[rl][cl];
        return findUniquePaths(obstacleGrid, 0, 0, rl, cl, dp);
    }

     int findUniquePaths(int[][] obstacleGrid, int r, int c, int rl, int cl, Integer[][] dp) {
        if (r == rl || c == cl) return 0;
        if (obstacleGrid[r][c] == 1)
             return 0;
         if (r == rl-1 && c == cl-1)
            return 1;
        if (dp[r][c] != null)
            return dp[r][c];

        int right = findUniquePaths(obstacleGrid, r, c+1, rl, cl, dp);
        int down = findUniquePaths(obstacleGrid, r+1, c, rl, cl, dp);

        return dp[r][c] = right + down;
     }
}
