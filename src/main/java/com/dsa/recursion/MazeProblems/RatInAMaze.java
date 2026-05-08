package com.dsa.recursion.MazeProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class RatInAMaze {
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
