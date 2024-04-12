package com.xtu;

public class LC2923 {

    public int findChampion(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            boolean flag = true;
            for (int j = 0; j < grid[0].length; j++) {
                if (i != j && grid[i][j] == 0) {
                    flag = false;
                }
            }
            if (flag) {
                return i;
            }
        }

        return -1;

    }
}
