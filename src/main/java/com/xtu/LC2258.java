package com.xtu;

import java.util.ArrayList;
import java.util.List;

public class LC2258 {

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * LC2258,人最多能停留的分钟数，使用二分查找和dfs方法
     *
     * @param grid 每个坐标所代表的物品
     * @return
     */
    public int maximumMinutes(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 这里我用开区间二分（其它写法也可以）
        int left = -1, right = m * n + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(grid, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left < m * n ? left : 1_000_000_000;
    }

    // 返回能否在初始位置停留 t 分钟，并安全到达安全屋
    private boolean check(int[][] grid, int t) {
        int m = grid.length, n = grid[0].length;
        boolean[][] onFire = new boolean[m][n];
        List<int[]> f = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    onFire[i][j] = true; // 标记着火的位置
                    f.add(new int[]{i, j});
                }
            }
        }
        while (t-- > 0 && !f.isEmpty()) { // 如果火无法扩散就提前退出
            f = spreadFire(grid, onFire, f); // 火扩散
        }
        if (onFire[0][0]) {
            return false; // 起点着火，寄
        }

        // 人的 BFS
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        List<int[]> q = List.of(new int[]{0, 0});
        while (!q.isEmpty()) {
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] p : tmp) {
                if (onFire[p[0]][p[1]]) { // 人走到这个位置后，火也扩散到了这个位置
                    continue;
                }
                for (int[] d : DIRS) { // 枚举上下左右四个方向
                    int x = p[0] + d[0], y = p[1] + d[1];
                    if (0 <= x && x < m && 0 <= y && y < n && !onFire[x][y] && !vis[x][y] && grid[x][y] == 0) {
                        if (x == m - 1 && y == n - 1) {
                            return true; // 我们安全了…暂时。
                        }
                        vis[x][y] = true; // 避免反复访问同一个位置
                        q.add(new int[]{x, y});
                    }
                }
            }
            f = spreadFire(grid, onFire, f); // 火扩散
        }
        return false; // 人被火烧到，或者没有可以到达安全屋的路
    }

    // 火的 BFS
    private List<int[]> spreadFire(int[][] grid, boolean[][] fire, List<int[]> f) {
        int m = grid.length, n = grid[0].length;
        List<int[]> tmp = f;
        f = new ArrayList<>();
        for (int[] p : tmp) {
            for (int[] d : DIRS) { // 枚举上下左右四个方向
                int x = p[0] + d[0], y = p[1] + d[1];
                if (0 <= x && x < m && 0 <= y && y < n && !fire[x][y] && grid[x][y] == 0) {
                    fire[x][y] = true; // 标记着火的位置
                    f.add(new int[]{x, y});
                }
            }
        }
        return f;
    }


}
