package com.dsa.recursion.MazeProblems;

public class UniquePathsIII {
    public int uniquePathsIII(int[][] grid) {
        int count = 0, startRow = -1, startCol = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    startRow = i;
                    startCol = j;
                }
                else if (grid[i][j] != -1) {
                    count++;
                }
            }
        }
        return backtrack (grid, startRow, startCol, count);
    }

    int backtrack (int[][] grid, int r, int c, int remaining) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] == -1) return 0;
        if (grid[r][c] == 2)
            return (remaining == 1) ? 1 : 0;

        remaining--;
        int temp = grid[r][c];
        grid[r][c] = -1;

        int paths = backtrack (grid, r, c+1, remaining) +
                backtrack (grid, r, c-1, remaining) +
                backtrack (grid, r+1, c, remaining) +
                backtrack (grid, r-1, c, remaining);

        grid[r][c] = temp;

        return paths;
    }
}
