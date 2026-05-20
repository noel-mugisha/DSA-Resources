package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NKnights {

    public static void main(String[] args) {
        System.out.println(solveNKnights(4));
    }

    static int solveNKnights(int n) {
        char[][] board = new char[n][n];
        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }
        List<List<String>> nKnights = new ArrayList<>();
        backtrack (board, n, 0, 0, n, nKnights);

        return nKnights.size();
    }

    static void backtrack(char[][] board, int n, int row, int col, int remaining, List<List<String>> nKnights) {
        if (remaining == 0) {
            List<String> current = new ArrayList<>();
            for (char[] arr : board) {
                current.add(new String(arr));
            }
            nKnights.add(current);
            return;
        }

        if (row == n)
            return;

        if (col == n) {
            backtrack(board, n, row + 1, 0, remaining, nKnights);
            return;
        }

        if (isSafe(board, row, col, n)) {
            board[row][col] = 'K';
            backtrack(board, n, row, col+1, remaining-1, nKnights);
            board[row][col] = '.';
        }

        backtrack(board, n, row, col + 1, remaining, nKnights);
    }

    static boolean isSafe(char[][] board, int row, int col, int n) {
        return checkIsSafe(board, row-2, col+1, n) && checkIsSafe(board, row-2, col-1, n)
                && checkIsSafe(board, row-1, col+2, n) && checkIsSafe(board, row-1, col-2, n);
    }

    static boolean checkIsSafe (char[][] board, int row, int col, int n) {
        if (row < 0 || col < 0 || col >= n)
            return true;

        return (board[row][col] == 'K') ? false : true;
    }
}
