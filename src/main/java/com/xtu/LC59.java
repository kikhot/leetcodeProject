package com.xtu;

public class LC59 {
    public int[][] generateMatrix(int n) {
        int xIndex = 0;
        int yIndex = 0;
        int loop = 0;

        int[][] resultNum = new int[n][n];
        int start = 0;
        int count = 1;

        while (loop++ < n / 2) {
            for (yIndex = start; yIndex < n - loop; yIndex++) {
                resultNum[start][yIndex] = count++;
            }
            for (xIndex = start; xIndex < n - loop; xIndex++) {
                resultNum[xIndex][yIndex] = count++;
            }
            for (yIndex = n - loop; yIndex > start; yIndex--) {
                resultNum[xIndex][yIndex] = count++;
            }
            for (xIndex = n - loop; xIndex > start; xIndex--) {
                resultNum[xIndex][yIndex] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            resultNum[start][start] = count;
        }
        return resultNum;
    }
}
