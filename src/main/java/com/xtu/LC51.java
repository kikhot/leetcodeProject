package com.xtu;

import java.util.*;

/**
 * N皇后，回溯法
 */
public class LC51 {

    public List<List<String>> resultList = new ArrayList<>();

    public int[] flag;

    public List<List<String>> solveNQueens(int n) {
        flag = new int[n];
        HashSet<Integer> path = new HashSet<>();
        backtrack(0, n, path);
        return resultList;
    }

    public void backtrack(int r, int n, HashSet<Integer> path) {
        if (r == n) {
            List<String> list = new ArrayList<>();
            for (int c : flag) {
                StringBuilder sb = new StringBuilder();
                sb.append(".".repeat(Math.max(0, c)));
                sb.append("Q");
                sb.append(".".repeat(Math.max(0, n - c - 1)));
                list.add(sb.toString());
            }
            resultList.add(list);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!path.contains(c) && valid(r, c)) {
                flag[r] = c;
                path.add(c);
                backtrack(r + 1, n, path);
                path.remove(c);
            }
        }

    }

    public boolean valid(int r, int c) {
        for (int i = 0; i < r; i++) {
            int R = i;
            int S = flag[i];
            if (r - c == R - S || r + c == R + S) {
                return false;
            }
        }
        return true;
    }

}
