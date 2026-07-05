package com.dsa.BOOK.ArraysAndStrings;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println(Arrays.deepToString(rotateMatrix(matrix)));
    }

    // Brute force (On^2) space complexity
    static int[][] rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int newRow = c;
                int newCol = n - 1 - r;
                newMatrix[newRow][newCol] = matrix[r][c];
            }
        }

        return newMatrix;
    }

    // Optimized way (O(n)) space complexity
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose matrix
        for (int r = 0; r < n; r++) {
            for (int c = r + 1; c < n; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        // Then reverse the rows
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;

                l++; r--;
            }
        }
    }
}
