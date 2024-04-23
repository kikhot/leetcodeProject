package com.xtu;

import java.util.Arrays;

public class LC200 {

    public boolean[][] flag;

    public int numIslands(char[][] grid) {
        int resCount = 0;
        flag = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !flag[i][j]) {
                    dfs(i, j, grid);
                    resCount++;
                }
            }
        }
        return resCount;
    }


    public void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }

        if (flag[i][j]) {
            return;
        }

        flag[i][j] = true;

        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }

}
