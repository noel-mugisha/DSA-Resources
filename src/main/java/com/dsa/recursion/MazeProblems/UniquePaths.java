package com.dsa.recursion.MazeProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
    }

    static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return findUniquePaths(0, 0, m, n, dp);
    }

    static int findUniquePaths(int r, int c, int m, int n, int[][] dp) {
        if (r == m-1 || c == n-1)
            return 1;

        if (dp[r][c] != 0)
            return dp[r][c];

        int right = findUniquePaths(r, c+1, m, n, dp);
        int down = findUniquePaths(r+1, c, m, n, dp);

        return dp[r][c] = right + down;
    }

    public static class RatInAMaze {
        public static void main(String[] args) {
            int[][] maze = {
                    {1, 0, 0},
                    {1, 1, 0},
                    {1, 1, 1}
            };
            System.out.println(findPath(maze));
        }

        static List<String> findPath(int[][] maze) {
            List<String> paths = new ArrayList<>();
            StringBuilder current = new StringBuilder();
            if (maze[0][0] == 0) return paths;
            backtrack (maze, 0, 0, current, paths);
            Collections.sort(paths);
            return paths;
        }

        static void backtrack(int[][] maze, int r, int c , StringBuilder current, List<String> paths) {
            if (r < 0 || c < 0 || r == maze.length || c == maze[0].length || maze[r][c] != 1) return;
            if (r == maze.length-1 && c == maze[0].length-1) {
                paths.add(current.toString());
                return;
            }

            maze[r][c] = -1;

            current.append('R');
            backtrack(maze, r, c+1, current, paths);
            current.deleteCharAt(current.length() - 1);

            current.append('L');
            backtrack(maze, r, c-1, current, paths);
            current.deleteCharAt(current.length() - 1);

            current.append('D');
            backtrack(maze, r+1, c, current, paths);
            current.deleteCharAt(current.length() - 1);

            current.append('U');
            backtrack(maze, r-1, c, current, paths);
            current.deleteCharAt(current.length() - 1);

            maze[r][c] = 1;
        }
    }
}
