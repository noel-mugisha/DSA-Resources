package com.dsa.BOOK.ArraysAndStrings;

import java.util.Arrays;

public class ZeroMatrix {
    public static void main(String[] args) {
        int [][] arr = {
                {1},
                {0}
        };
        setZeroes(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    static void setZeroes(int[][] matrix) {
        boolean firstRowHasZero = checkFirstRowOrCol(matrix, 'r');
        boolean firstColHasZero = checkFirstRowOrCol(matrix, 'c');
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1; r < rows; r++) {
            if (matrix[r][0] == 0)
                Arrays.fill(matrix[r], 0);
        }

        for (int c = 1; c < cols; c++) {
            if (matrix[0][c] == 0)
                setColToZero(matrix ,c);
        }

        if (firstRowHasZero)
            Arrays.fill(matrix[0], 0);

        if (firstColHasZero)
            setColToZero(matrix, 0);
    }

    static void setColToZero(int[][] matrix ,int c) {
        for (int r = 0; r < matrix.length; r++)
            matrix[r][c] = 0;
    }

    static boolean checkFirstRowOrCol(int[][] matrix, char isRowOrCol) {
        if (isRowOrCol == 'r') {
            for (int c = 0; c < matrix[0].length; c++) {
                if (matrix[0][c] == 0)
                    return true;
            }
        } else {
            for (int[] ints : matrix) {
                if (ints[0] == 0)
                    return true;
            }
        }

        return false;
    }
}
