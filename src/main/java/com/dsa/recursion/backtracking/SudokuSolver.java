package com.dsa.recursion.backtracking;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        backtrack (board, 0, 0, board.length);
    }

    boolean backtrack(char[][] board, int row, int col, int n) {
        if (row == n)
            return true;

        if (col == n)
            return backtrack(board, row + 1, 0, n);

        if (board[row][col] != '.')
            return backtrack(board, row, col + 1, n);

        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = (char) (num + '0');
                if (backtrack(board, row, col + 1, n))
                    return true;
                board[row][col] = '.';
            }
        }

        return false;
    }

    boolean isSafe(char[][] board, int row, int col, int num) {
        int n = board.length;
        char ch = (char) (num + '0');
        // check whole col
        for (int c = 0; c < n; c++) {
            if (board[row][c] == ch)
                return false;
        }
        // check whole row
        for (int r = 0; r < n; r++) {
            if (board[r][col] == ch)
                return false;
        }
        // check box
        int startR = (row / 3) * 3;
        int startC = (col / 3) * 3;
        for (int r = startR; r < startR + 3; r++) {
            for (int c = startC; c < startC + 3; c++) {
                if (board[r][c] == ch)
                    return false;
            }
        }
        return true;
    }
}
