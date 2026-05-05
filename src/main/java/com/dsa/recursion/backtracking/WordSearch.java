package com.dsa.recursion.backtracking;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rl = board.length;
        int cl = board[0].length;

        for (int r = 0; r < rl; r++) {
            for (int c = 0; c < cl; c++) {
                if (backtrack(board, word, 0, r, c))
                    return true;
            }
        }

        return false;
    }

    boolean backtrack(char[][] board, String word, int i, int r, int c) {
        if (i == word.length()) return true;
        if (
                r < 0 || c < 0
                || r == board.length || c == board[0].length
                || word.charAt(i) != board[r][c]
        ) return false;

        char temp = board[r][c];
        board[r][c] = '#';

        boolean isFound = backtrack(board, word, i+1, r, c+1) || //right
                backtrack(board, word, i+1, r, c-1) || //left
                backtrack(board, word, i+1, r+1, c) || //down
                backtrack(board, word, i+1, r-1, c);// up

        board[r][c] = temp;
        return isFound;
    }
}












