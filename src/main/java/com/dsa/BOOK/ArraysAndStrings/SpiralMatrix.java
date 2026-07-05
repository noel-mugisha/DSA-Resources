package com.dsa.BOOK.ArraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},{5,6,7,8},{9,10,11,12}
        };

        System.out.println(spiralOrder(arr));
    }
    static public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int rowBegin = 0, colBegin = 0;
        int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse right
            for (int i = colBegin; i <= colEnd; i++) {
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            // Traverse Down
            for (int i = rowBegin; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Check now if they wont be no duplicates
            if (rowBegin > rowEnd || colBegin > colEnd)
                break;

            // Traverse left
            for (int i = colEnd; i >= colBegin; i--) {
                res.add(matrix[rowEnd][i]);
            }
            rowEnd--;

            // Traverse up
            for (int i = rowEnd; i >= rowBegin; i--) {
                res.add(matrix[i][colBegin]);
            }
            colBegin++;
        }
        return res;
    }
}
