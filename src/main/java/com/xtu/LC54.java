package com.xtu;

import java.util.Arrays;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Integer[] resultNum = new Integer[m * n];
        int l = 0;
        int r = n - 1;
        int t = 0;
        int b = m - 1;
        int index = 0;

        while (true) {
            for (int i = l; i <= r; i++) {
                resultNum[index++] = matrix[t][i];
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {
                resultNum[index++] = matrix[i][r];
            }
            if (--r < l) break;
            for (int i = r; i >= l; i--) {
                resultNum[index++] = matrix[b][i];
            }
            if (--b < t) break;
            for (int i = b; i >= t; i--) {
                resultNum[index++] = matrix[i][l];
            }
            if (++l > r) break;
        }

        return Arrays.asList(resultNum);
    }
}
