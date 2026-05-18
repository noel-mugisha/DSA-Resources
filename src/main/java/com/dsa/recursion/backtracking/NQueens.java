package com.dsa.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> nQueens = new ArrayList<>();
        char[][] board = new char[n][n];

        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }

        backtrack (board, 0, n, nQueens);

        return nQueens;
    }

    void backtrack(char[][] board, int row, int n, List<List<String>> nQueens) {
        if (row == n) {
            List<String> queens = new ArrayList<>();
            for (char[] r : board) {
                queens.add(new String(r));
            }
            nQueens.add(queens);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n, nQueens);
                board[row][col] = '.';
            }
        }
    }

    boolean isSafe(char[][] board, int row, int col, int n) {
        // check upward, (if they are in same column)
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        // check left diagonal
        for (int i = row-1, j = col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // check right diagonal
        for (int i = row-1, j = col+1; i>=0 && j<n ; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
