package com.xtu;

/**
 * 执行用时：21 ms, 在所有 Java 提交中击败了32.76%的用户
 * 内存消耗：39.1 MB, 在所有 Java 提交中击败了5.67%的用户
 * 通过测试用例：51 / 51
 */
public class lc1219 {

    public int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    int ans = 0;
    int grid[][];
    int m,n;

    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] != 0)
                    dfs(i,j,0);
            }
        }

        return ans;
    }

    public void dfs(int i,int j,int gold){
        gold += grid[i][j];
        ans = Math.max(gold,ans);
        int tem = grid[i][j];
        grid[i][j] = 0;

        for(int d=0;d<4;d++){
            int newX = dir[d][0] + i;
            int newY = dir[d][1] + j;
            if(newX>=0 && newX<m && newY>=0 && newY<n && grid[newX][newY]>0){
                dfs(newX,newY,gold);
            }
        }

        grid[i][j] = tem;

    }

}
