package com.xtu;

/**
 * 使用二维的前缀和数组方法
 */
public class LC304 {

    class NumMatrix {

        private int[][] preSums;

        /**
         * 初始化前缀和数组
         *
         * @param matrix
         */
        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            preSums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    preSums[i + 1][j + 1] = matrix[i][j] + preSums[i][j + 1] + preSums[i + 1][j] - preSums[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSums[row2 + 1][col2 + 1] - preSums[row1][col2 + 1] - preSums[row2 + 1][col1] + preSums[row1][col1];
        }
    }
}
